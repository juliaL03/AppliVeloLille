package com.example.levenj.vlille;

import android.content.Context;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by levenj on 22/09/14.
 */
public class StationsParser extends DefaultHandler {
        private ArrayList<StationsVLille> arrList;
        private XMLReader xr;
        private Context ctx;


        public StationsParser(Context ctx) throws Exception {
            this.ctx = ctx;
            URL urlBase = new URL("http://www.velib.paris.fr/service/carto");
            InputSource is = new InputSource(urlBase.openStream());

// traitement du parsing XML : factory XML, ...
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            xr = sp.getXMLReader();
            xr.setContentHandler(this);
            xr.parse(is);
        }

        public ArrayList<StationsVLille> getArrList() {
            return arrList;
        }


        public void setArrList(ArrayList<StationsVLille> arrList) {
            this.arrList = arrList;
        }


        public void endDocument() throws SAXException {
            super.endDocument();
        }


        public void startDocument() throws SAXException {
            super.startDocument();
            arrList = new ArrayList<StationsVLille>();
        }


        /*public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if (localName.equals("marker")) {
                StationsVLille s = new StationsVLille();
                s.setNom(attributes.getValue("name"));
                arrList.add(s);
            }
        }*/

}
