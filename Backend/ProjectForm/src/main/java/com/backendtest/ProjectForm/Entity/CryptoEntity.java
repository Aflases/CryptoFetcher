package com.backendtest.ProjectForm.Entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Document
public class CryptoEntity{
	
	 	
	    private String name;
	    private String symbol;
	    private Integer rank;
	    private Integer age;
	    private String color;
	    @Id
	    private String code;
	    private Integer exchanges;
	    private Integer markets;
	    private Double allTimeHighUSD;
	    private Long circulatingSupply;
	    private Long totalSupply;
	    private Long maxSupply;
	    private Double rate;
	    private Long volume;
	    private Long cap;
	    private List<History> history;
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public Integer getRank() {
			return rank;
		}
		public void setRank(Integer rank) {
			this.rank = rank;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Integer getExchanges() {
			return exchanges;
		}
		public void setExchanges(Integer exchanges) {
			this.exchanges = exchanges;
		}
		public Integer getMarkets() {
			return markets;
		}
		public void setMarkets(Integer markets) {
			this.markets = markets;
		}
		public Double getAllTimeHighUSD() {
			return allTimeHighUSD;
		}
		public void setAllTimeHighUSD(Double allTimeHighUSD) {
			this.allTimeHighUSD = allTimeHighUSD;
		}
		public Long getCirculatingSupply() {
			return circulatingSupply;
		}
		public void setCirculatingSupply(Long circulatingSupply) {
			this.circulatingSupply = circulatingSupply;
		}
		public Long getTotalSupply() {
			return totalSupply;
		}
		public void setTotalSupply(Long totalSupply) {
			this.totalSupply = totalSupply;
		}
		public Long getMaxSupply() {
			return maxSupply;
		}
		public void setMaxSupply(Long maxSupply) {
			this.maxSupply = maxSupply;
		}
		public Double getRate() {
			return rate;
		}
		public void setRate(Double rate) {
			this.rate = rate;
		}
		public Long getVolume() {
			return volume;
		}
		public void setVolume(Long volume) {
			this.volume = volume;
		}
		public Long getCap() {
			return cap;
		}
		public void setCap(Long cap) {
			this.cap = cap;
		}
		public List<History> getHistory() {
			return history;
		}
		public void setHistory(List<History> history) {
			this.history = history;
		}
		@Override
		public String toString() {
			return "CryptoEntity [name=" + name + ", symbol=" + symbol + ", rank=" + rank + ", age=" + age + ", color="
					+ color + ", code=" + code + ", exchanges=" + exchanges + ", markets=" + markets
					+ ", allTimeHighUSD=" + allTimeHighUSD + ", circulatingSupply=" + circulatingSupply
					+ ", totalSupply=" + totalSupply + ", maxSupply=" + maxSupply + ", rate=" + rate + ", volume="
					+ volume + ", cap=" + cap + ", history=" + history + "]";
		}
		public CryptoEntity(String name, String symbol, Integer rank, Integer age, String color, String code,
				Integer exchanges, Integer markets, Double allTimeHighUSD, Long circulatingSupply, Long totalSupply,
				Long maxSupply, Double rate, Long volume, Long cap, List<History> history) {
			super();
			this.name = name;
			this.symbol = symbol;
			this.rank = rank;
			this.age = age;
			this.color = color;
			this.code = code;
			this.exchanges = exchanges;
			this.markets = markets;
			this.allTimeHighUSD = allTimeHighUSD;
			this.circulatingSupply = circulatingSupply;
			this.totalSupply = totalSupply;
			this.maxSupply = maxSupply;
			this.rate = rate;
			this.volume = volume;
			this.cap = cap;
			this.history = history;
		}
		public CryptoEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
		
		
	    
		
}