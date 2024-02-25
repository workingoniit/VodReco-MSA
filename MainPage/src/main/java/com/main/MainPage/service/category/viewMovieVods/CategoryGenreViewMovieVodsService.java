package com.main.MainPage.service.category.viewMovieVods;

import com.main.MainPage.dto.BasicInfoOfVodDto;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public interface CategoryGenreViewMovieVodsService {
    List<BasicInfoOfVodDto> getMovieVodsInfo(String genre2) throws UnsupportedEncodingException;
}
