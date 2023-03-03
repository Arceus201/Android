package com.example.thread.RSS_AsynTask;

import com.example.thread.RSS_AsynTask.model.Item;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MySaxHandler extends DefaultHandler {
    private List<Item> list;
    private Item item;
    private String temp;
    private boolean flagstart = false;

    public MySaxHandler() {
        list = new ArrayList<>();
    }
    public List<Item> getItem(){
        return list;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(flagstart == true){
            temp = new String(ch,start,length);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equalsIgnoreCase("item")){
            item = new Item();
            flagstart = true;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equalsIgnoreCase("item")){
            list.add(item);
        }if(qName.equalsIgnoreCase("title")){
            item.setTitle(temp);
        }if(qName.equalsIgnoreCase("description")){
            item.setDes(temp);
        }if(qName.equalsIgnoreCase("pubDate")){
            item.setPubdate(temp);
        }if(qName.equalsIgnoreCase("link")){
            item.setLink(temp);
        }

    }
}
