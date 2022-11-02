package com.main.models;

public class SlipClass {

	private Slip slip;

	public Slip getSlip() {
		return slip;
	}

	public void setSlip(Slip slip) {
		this.slip = slip;
	}

	@Override
	public String toString() {
		return "Slip [slip= " + slip + "]";
	}

	public class Slip {

		private Integer id;
		private String advice;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getAdvice() {
			return advice;
		}

		public void setAdvice(String advice) {
			this.advice = advice;
		}

		@Override
		public String toString() {
			return "[id= " + id + ", advice= " + advice + "]";
		}

	}
}