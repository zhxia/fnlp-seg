package com.yknet.fnlp.service;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FnlpService {
    protected CNFactory factory;

    public FnlpService() {
        try {
            this.factory = CNFactory.getInstance("models");
        } catch (LoadModelException e) {
            e.printStackTrace();
        }
    }

    public List<String> segment(String sentence) {
        List<String> result = new ArrayList<>();
        if (!"".equals(sentence.trim())) {
            String[] words = this.factory.seg(sentence.trim());
            for (String word : words) {
                result.add(word);
            }
        }
        return result;
    }

}
