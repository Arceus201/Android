package com.example.thread.RSS_AsynTask;

import android.util.Log;

import com.example.thread.RSS_AsynTask.model.Item;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

public class MySaxParser {
    public static List<Item> xmlParser(InputStream is) {
        List<Item> list = null;
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            MySaxHandler handler = new MySaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(is));
            list = handler.getItem();
        }catch (Exception e){
            Log.d("loi",e.getMessage());
        }
        return list;
    }

}
