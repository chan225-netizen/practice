package org.example.test.service;

import java.util.List;

/**
 *
 */
public interface Word {

    /**
     *
     * @param word
     */
    void addWord(String word);

    /**
     * <p>返回单词本包含的词</p>
     */
    List<String> findKeyWord(String content);
}
