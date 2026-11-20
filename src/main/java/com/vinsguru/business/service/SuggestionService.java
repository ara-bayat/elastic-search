package com.vinsguru.business.service;

import com.vinsguru.business.dto.SuggestionRequestParameters;
import com.vinsguru.business.util.Constants;
import com.vinsguru.business.util.NativeQueryBuilder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.suggest.response.Suggest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuggestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuggestionService.class);
    private final ElasticsearchOperations elasticsearchOperations;


    public List<String> fetchSuggestions(SuggestionRequestParameters parameter) {
        LOGGER.info("Fetching suggestions {}", parameter);
        var query = NativeQueryBuilder.toSuggestQuery(parameter);
        var searchHit = this.elasticsearchOperations.search(query, Object.class, Constants.Index.SUGGESTION);
        return Optional.ofNullable(searchHit.getSuggest())
                .map(s -> s.getSuggestion(Constants.Suggestion.SUGGEST_NAME))
                .stream()
                .map(Suggest.Suggestion::getEntries)
                .flatMap(List::stream)
                .map(Suggest.Suggestion.Entry::getOptions)
                .flatMap(Collection::stream)
                .map(Suggest.Suggestion.Entry.Option::getText)
                .toList();


    }
}
