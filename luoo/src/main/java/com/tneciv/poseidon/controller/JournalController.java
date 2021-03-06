package com.tneciv.poseidon.controller;

import com.tneciv.poseidon.common.PageVo;
import com.tneciv.poseidon.common.ResponseWrapper;
import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.service.JournalService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/26.
 */
@RestController
@RequestMapping("/journal")
@Slf4j
public class JournalController {

    @Autowired
    private JournalService journalService;

    @ApiOperation(value = "获取期刊详细信息", notes = "根据url的id来获取期刊详细信息")
    @ApiImplicitParam(name = "id", value = "期刊ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResponseWrapper<JournalDto> queryById(@PathVariable("id") Integer id) {
        JournalDto journalDto = journalService.queryByJournalId(id);
        return ResponseWrapper.success(journalDto);
    }

    @GetMapping("/keyword")
    public PageVo<JournalDto> queryListByKeyword(@RequestParam("keyword") String keyword,
                                                 @RequestParam("pageNum") Integer pageNum,
                                                 @RequestParam("pageSize") Integer pageSize) {
        PageVo<JournalDto> voDto = journalService.queryByKeyword(keyword, pageNum, pageSize);
        return voDto;
    }

    @GetMapping("/title/{title}")
    public ResponseWrapper<List<JournalDto>> queryListByTitle(@PathVariable("title") String title) {
        List<JournalDto> journalList = journalService.queryByTitle(title);
        return ResponseWrapper.success(journalList);
    }

    @GetMapping("/recent")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<List<JournalDto>> queryRecent() {
        List<JournalDto> journalList = journalService.queryRecent();
        return ResponseWrapper.success(journalList);
    }

}
