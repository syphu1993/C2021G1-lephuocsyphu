package dictionary.service.impl;

import dictionary.service.ITranslation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationImpl implements ITranslation {
    @Override
    public String translate(String word) {
        Map<String,String> dictionaryMap = new HashMap<>();
        dictionaryMap.put("hello","xin chào");
        dictionaryMap.put("good","tốt");
        dictionaryMap.put("bad","xấu");
        dictionaryMap.put("mop","lau chùi");
        dictionaryMap.put("swept","quét");
        dictionaryMap.put("stack","xếp chồng");
        if (!dictionaryMap.containsKey(word)){
            return "Not Found";
        } else {
           return dictionaryMap.get(word);
        }
    }
}
