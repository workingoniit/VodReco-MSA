package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InsertOrUpdateMyRatingDto {
    private String uniqueId;
    private String subsr;
    private String contentId;
    private Integer rating;
    private String review;
    private String rating_date;
    private String title;
    private String posterurl;

    @Builder
    public InsertOrUpdateMyRatingDto(String uniqueId, String subsr, String contentId, Integer rating, String review, String rating_date, String title, String posterurl) {
        this.uniqueId = uniqueId;
        this.subsr = subsr;
        this.contentId = contentId;
        this.rating = rating;
        this.review = review;
        this.rating_date = rating_date;
        this.title = title;
        this.posterurl = posterurl;
    }

}

