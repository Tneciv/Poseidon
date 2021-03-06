package com.tneciv.poseidon.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tneciv.poseidon.common.ApplicationException;
import com.tneciv.poseidon.common.CommonUtil;
import com.tneciv.poseidon.common.PageVo;
import com.tneciv.poseidon.dao.JournalExtMapper;
import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.entity.JournalExample;
import com.tneciv.poseidon.entity.Track;
import com.tneciv.poseidon.service.JournalService;
import com.tneciv.poseidon.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tneciv on 2017/3/27.
 */
@Service
@Slf4j
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalExtMapper journalMapper;
    @Autowired
    private TrackService trackService;

    @Override
    public JournalDto queryByJournalId(Integer id) {
        Journal journal = journalMapper.queryByJournalId(id);
        JournalDto dto = this.parseJournalDto(journal);
        return dto;
    }

    @Override
    public List<JournalDto> queryByTitle(String title) {
        JournalExample example = new JournalExample();
        JournalExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike(CommonUtil.spliceLikeSQL(title));
        List<Journal> list = journalMapper.selectByExampleWithBLOBs(example);
        return this.parseJournalDto(list);
    }

    @Override
    public List<JournalDto> queryByKeyWord(String keyword, int pageNum, int pageSize) {
        JournalExample example = new JournalExample();
        JournalExample.Criteria criteria = example.createCriteria();
        criteria.andKeyWordsLike(CommonUtil.spliceLikeSQL(keyword));
        PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> journalMapper.selectByExampleWithBLOBs(example));
        List<Journal> list = journalMapper.selectByExampleWithBLOBs(example);
        return this.parseJournalDto(list);
    }

    @Override
    public PageVo<JournalDto> queryByKeyword(String keyword, Integer pageNum, Integer pageSize) {
        JournalExample example = new JournalExample();
        JournalExample.Criteria criteria = example.createCriteria();
        criteria.andKeyWordsLike(CommonUtil.spliceLikeSQL(keyword));
        PageInfo<Journal> pageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> journalMapper.selectByExampleWithBLOBs(example));
        List<JournalDto> dtos = this.parseJournalDto(pageInfo.getList());
        PageVo<JournalDto> voDto = new PageVo<>(pageInfo, dtos);
        return voDto;
    }

    @Override
    public List<JournalDto> queryRecent() {
        PageHelper.startPage(0, 10);
        List<Journal> journals = this.journalMapper.queryRecent();
        List<JournalDto> dtos = this.parseJournalDto(journals);
        return dtos;
    }

    private List<JournalDto> parseJournalDto(List<Journal> journalList) {
        return journalList.stream()
                .map(this::parseJournalDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private JournalDto parseJournalDto(Journal journal) {
        if (journal == null) {
            throw new ApplicationException("期刊内容为空");
        }
        JournalDto dto = new JournalDto();
        String journalTracks = journal.getTracks();
        int[] list = CommonUtil.convertStringToIntArr(journalTracks);
        List<Track> trackList = this.trackService.queryListByTrackIds(list);
        dto.setTracksList(trackList);
        dto.setId(journal.getId());
        dto.setTitle(journal.getTitle());
        dto.setKeyWords(journal.getKeyWords());
        dto.setJournalId(journal.getJournalId());
        dto.setVolCoverImg(journal.getVolCoverImg());
        dto.setRelativeVols(journal.getRelativeVols());
        dto.setVolDate(journal.getVolDate());
        dto.setVolDesc(journal.getVolDesc());
        return dto;
    }

}
