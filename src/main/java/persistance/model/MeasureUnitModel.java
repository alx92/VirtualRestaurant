package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to MeasureUnitModel
@Entity
@Table (name = "um")
public class MeasureUnitModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "um_id")
    private Integer measureUnitId;

    @Column(name = "descriere")
    private String measureUnitType;

    public Integer getMeasureUnitId()
    {
        return measureUnitId;
    }

    public void setMeasureUnitId(Integer measureUnitId)
    {
        this.measureUnitId = measureUnitId;
    }

    public String getMeasureUnitType()
    {
        return measureUnitType;
    }

    public void setMeasureUnitType(String measureUnitType)
    {
        this.measureUnitType = measureUnitType;
    }
}
