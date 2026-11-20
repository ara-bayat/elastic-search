package com.vinsguru.business.util;

import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

public class Constants  {

    private Constants(){}

    public static class Index{
        public static IndexCoordinates SUGGESTION=IndexCoordinates.of("suggestion");
        public static IndexCoordinates BUSSINESS=IndexCoordinates.of("bussiness");

    }
    public static class Suggestion{
        public static final String SEARCH_TERM="search_term";
        public static final String SUGGEST_NAME="search_term_suggest";
    }
    public static class Fuzzy{
        public static final String LEVEL="1";
        public static final Integer PREFIX_LENGTH=2;
    }
}
