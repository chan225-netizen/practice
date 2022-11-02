package org.example.test.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WordImpl implements Word {

    private static List<String> keyWordList = new ArrayList<>();

    /**
     * 添加单词到keyWordList
     * @param word
     */
    @Override
    public void addWord(String word) {
        if (keyWordList.contains(word)) {
            return;
        }
        keyWordList.add(word);
    }

    /**
     * 根据content到keyWordList中查询
     * @param content
     * @return 返回包含content的集合
     */
    @Override
    public List<String> findKeyWord(String content) {
        List<String> resultList = new ArrayList<>();
        if (StringUtils.isEmpty(content)) {
            return resultList;
        }

        for (String word : keyWordList) {
            if (content.indexOf(word) > -1) {
                resultList.add(word);
            }
        }

        return resultList;
    }

}
