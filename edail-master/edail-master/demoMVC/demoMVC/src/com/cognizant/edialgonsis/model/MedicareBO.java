package com.cognizant.edialgonsis.model;

public class MedicareBO {

	public boolean insert_Medicare(Medicare_Services med) {
	MedicareDAO meddao= new MedicareDAO();
		boolean res;
		res=meddao.insertMedicare(med);
		return res;
	}

	public Medicare_Services fetchMedicare(int id) {
		MedicareDAO meddao=new MedicareDAO();
		Medicare_Services med=new Medicare_Services();
		med=meddao.fetchMedicare(id);
		// TODO Auto-generated method stub
		return med;
	}

	public boolean updateMedicare(Medicare_Services med, int id) {
		MedicareDAO meddao=new MedicareDAO();
		boolean res;
		res=meddao.updateMedicare(med,id);
		return res;
	}



}
