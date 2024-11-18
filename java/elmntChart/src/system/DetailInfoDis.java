package system;

import java.util.ArrayList;
import java.util.List;

public class DetailInfoDis {

	private Integer atomNumber;
	private String elName;
	private String symbol;
	private Float mass;

	private String phaseSTP;
	private String color;

	private Integer phIndex;
	private String phDetail;

	private Float density;
	private String densityUnit;
	private Float meltPt;
	private Float boilPt;

	private String characteristics;

	private String egCompound;
	private String egProduct;

	private static List<DetailInfoDis> dataList = new ArrayList<>();

	public Integer getAtomNumber() { return atomNumber; }
    public String getElName() { return elName; }
    public String getSymbol() { return symbol; }
    public Float getMass() { return mass; }

    public String getPhaseSTP() { return phaseSTP; }
    public String getColor() { return color; }

    public Integer getPhIndex() { return phIndex; }
    public String getPhDetail() { return phDetail; }

    public Float getDensity() { return density; }
    public Float getMeltPt() { return meltPt; }
    public Float getBoilPt() { return boilPt; }

    public String getCharacteristics() { return characteristics; }

    public String getEgCompound() { return egCompound; }
    public String getEgProduct() { return egProduct; }

	private DetailInfoDis(Integer atomNumber, String elName, String symbol, Float mass, String phaseSTP, String color, Integer phIndex, String phDetail, Float density, String densityUnit, Float meltPt, Float boilPt, String characteristics, String egCompound, String egProduct){
		this.atomNumber = atomNumber;
		this.elName = elName;
		this.symbol = symbol;
		this.mass = mass;
		this.phaseSTP = phaseSTP;
		this.color = color;
		this.phIndex = phIndex;
		this.phDetail = phDetail;
		this.density = density;
		this.densityUnit = densityUnit;
		this.meltPt = meltPt;
		this.boilPt = boilPt;
		this.characteristics = characteristics;
		this.egCompound = egCompound;
		this.egProduct = egProduct;
	}

	public static DetailInfoDis getData(int index){
		if (index > 0 && index <= dataList.size()){
			return dataList.get(index - 1);
		} else{
			return new DetailInfoDis(null, "--", "--", null, "--", "--", null, null, null, "", null, null, "--", "--", "--");
		}
	}

	static {
		dataList.add(new DetailInfoDis(1, "Hydrogen", "H", 1.008f, "Gas", "Colorless", 0, null, 0.08988f, "g/L", -259.16f, -252.87f, "Hydrogen is the lightest and most abundant element in the universe, playing a crucial role in the formation of stars and planets.", "Water (H₂O), Methane (CH₄), Ammonia (NH₃)", "Fuel cells, Automotive fuel, Rocket propellants"));
		dataList.add(new DetailInfoDis(2, "Helium", "He", 4.0026f, "Gas", "Colorless", null, null, 0.1786f, "g/L", -272.2f, -268.93f, "Helium is a noble gas and the second lightest element, known for its low boiling point and non-reactivity.", "--", "Cryogenics, Airships, Breathing mixtures for deep-sea diving"));
	}

}
