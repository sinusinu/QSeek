package com.sinu.qseek;

public class UrlMap {
    public static String getUrlOfSite(String site) {
        switch (site) {
            case "us_cambridge":
                return "https://dictionary.cambridge.org/us/dictionary/english/%s";
            case "us_merriam":
                return "https://www.merriam-webster.com/dictionary/%s";
            case "kr_naver":
                return "https://m.search.naver.com/search.naver?where=m_ldic&query=%s";
            case "kr_daum":
                return "https://m.dic.daum.net/search.do?q=%s";
            default:
                return null;
        }
    }
}
