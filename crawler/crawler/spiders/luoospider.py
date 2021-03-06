# -*- coding: utf-8 -*-
# scrapy crawl luoo
import scrapy
from bs4 import BeautifulSoup

from crawler.luooItems import LuooItem
from crawler.trackItems import TrackItem


class LuooCrawler(scrapy.Spider):
    name = 'luoo'
    htmlParser = 'html.parser'
    href = 'href'
    isDebug = True

    def start_requests(self):
        urls = ['http://www.luoo.net/music']
        for url in urls:
            yield scrapy.Request(url, self.parse)

    def parse(self, response):
        
        # 请求返回的html源码，从首页开始，然后处理分页
        content = response.body
        if not content:
            self.log('parse body error.')
            return
        soup = BeautifulSoup(response.body, self.htmlParser)
        
        # 获取当前页面所有期刊url（这时候处理的还是首页 http://www.luoo.net/music 的）
        journalUrlList = []
        for nextPageUrl in soup.select('.vol-list .item'):
            item = nextPageUrl.select('.cover-wrapper')
            if item:
                url = item[0].get(self.href)
                journalUrlList.append(url)

        # 开始处理当前页面所有期刊
        for journalUrl in journalUrlList:
            yield scrapy.Request(journalUrl, self.parse_page)

        if (self.isDebug):
            return

        ## 处理完当前页开始找下一页地址，递归

        # 开始处理分页
        nextPageUrl = soup.select('.next')[0].get(self.href)

        # 此时为最后一页，收工
        if 'javascript' in nextPageUrl:
            self.log('All pages crawled')
            return
        # 不是最后一页，则继续爬取
        else:
            yield scrapy.Request(nextPageUrl, self.parse)

    # 处理页面详情，解析、存储
    def parse_page(self, response):
        soup = BeautifulSoup(response.body, self.htmlParser)
        luooItem = LuooItem()
        trackList = []
        cover = soup.select('.vol-cover-wrapper')
        tracksSoup = soup.select('.vol-tracklist')[0]

        if cover:
            coverImg = self.handleImgUrl(cover[0].img.get('src'))
            luooItem['volImg'] = coverImg

        luooItem['volDesc'] = soup.select('.vol-desc')[0].text
        luooItem['volKeywords'] = soup.find_all('meta', {'name': 'keywords'})[0]['content']
        luooItem['volTitle'] = soup.select('.vol-title')[0].text
        luooItem['volNumber'] = soup.select('.vol-number')[0].text
        luooItem['volDate'] = soup.select('.vol-date')[0].text

        for track in tracksSoup.select('.track-item'):
            item = self.handleItem(track)
            trackList.append(item)

        luooItem['volTracks'] = trackList
        self.log(luooItem)

    def handleItem(self, trackInfo):
        trackItem = TrackItem()
        self.log(trackInfo)
        trackItem['trackName'] = trackInfo.select('.trackname')[0].text
        trackItem['trackAlbum'] = trackInfo.select('.album')[0].text
        trackItem['trackArtist'] = trackInfo.select('.artist')[0].text
        trackItem['trackImg'] = trackInfo.select('.cover')[0]
        trackItem['trackMP3Url'] = 'xxxxx.mp3'
        return trackItem

    def handleImgUrl(self, imgSrc):
        prefix = '.jpg'
        coverImg = imgSrc.split(prefix)[0] + prefix
        return coverImg
