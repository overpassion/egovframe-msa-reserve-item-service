package org.egovframe.cloud.reserveitemservice.domain.location;

import lombok.*;
import org.egovframe.cloud.reactive.domain.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Size;

/**
 * org.egovframe.cloud.reserveitemservice.domain.location.Location
 *
 * 예약 지역 도메인 클래스
 *
 * @author 표준프레임워크센터 shinmj
 * @version 1.0
 * @since 2021/09/06
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일        수정자           수정내용
 *  ----------    --------    ---------------------------
 *  2021/09/06    shinmj       최초 생성
 * </pre>
 */
@Getter
@NoArgsConstructor
@ToString
@Table("location")
public class Location extends BaseEntity {

    @Id
    private Long locationId;

    @Size(max = 200)
    @Column
    private String locationName;
    @Column
    private Integer sortSeq;

    @Column("use_at")
    private Boolean isUse;

    @Builder
    public Location(Long locationId, String locationName, Integer sortSeq, Boolean isUse) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.sortSeq = sortSeq;
        this.isUse = isUse;
    }

    public Location update(String locationName, Integer sortSeq, Boolean isUse) {
        this.locationName = locationName;
        this.sortSeq = sortSeq;
        this.isUse = isUse;
        return this;
    }

    public Location updateIsUse(Boolean isUse) {
        this.isUse = isUse;
        return this;
    }
}
