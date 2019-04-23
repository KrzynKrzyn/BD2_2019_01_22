package com.bd2.app;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

	@Autowired
	private EntityManager em;
	
	private Query queryPermissions()
	{
		return em.createNativeQuery(
				"	SELECT k.\"Identyfikator\", u.\"Rodzaj\"\n" + 
				"	FROM \"Kierowca\" k, \"Nadane uprawnienia\" n, \"Uprawnienie\" u\n" + 
				"	WHERE 	k.\"Identyfikator\" = n.\"Kierowca\" \n" + 
				"		AND k.\"Identyfikator\" = :id\n" + 
				"		AND n.\"Uprawnienie\" = u.\"Rodzaj\";");
	}
	
	private Query queryMinCourse()
	{
		return em.createNativeQuery(
				"SELECT d.\"Identyfikator\", min(d.\"Liczba kursow\") as \"Min kursy\" FROM\n" + 
				"(\n" + 
				"	SELECT k.\"Identyfikator\", count(a) as \"Liczba kursow\" \n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \n" + 
				"		AND a.\"Data faktycznego zakończenia\" IS NOT NULL\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range1\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range2\n" + 
				"	GROUP BY k.\"Identyfikator\"\n" + 
				") d\n" + 
				"GROUP BY d.\"Identyfikator\";");
	}
	
	private Query queryMaxCourse()
	{
		return em.createNativeQuery(
				"SELECT d.\"Identyfikator\", max(d.\"Liczba kursow\") as \"Max kursy\" FROM\n" + 
				"(\n" + 
				"	SELECT k.\"Identyfikator\", count(a) as \"Liczba kursow\" \n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \n" + 
				"		AND a.\"Data faktycznego zakończenia\" IS NOT NULL\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range1\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range2\n" + 
				"	GROUP BY k.\"Identyfikator\"\n" + 
				") d\n" + 
				"GROUP BY d.\"Identyfikator\";");
	}
	
	private Query queryMaxPackage()
	{
		return em.createNativeQuery(
				"SELECT d.\"Identyfikator\", max(d.\"Liczba paczek\") as \"Max paczki\" FROM\n" + 
				"(\n" + 
				"	SELECT k.\"Identyfikator\", count(p) as \"Liczba paczek\" \n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a, \"Zmiana statusu paczki\" z, \"Paczka\" p, \"Zlecenie\" x\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \n" + 
				"		AND a.\"Identyfikator\" = z.\"Kurs\" \n" + 
				"		AND z.\"Paczka\" = p.\"Identyfikator\"\n" + 
				"		AND x.\"Identyfikator\" = p.\"Zlecenie\"\n" + 
				"		\n" + 
				"		AND p.\"Status\" = 'Dostarczono'\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range1\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range2\n" + 
				"	GROUP BY k.\"Identyfikator\"\n" + 
				") d\n" + 
				"GROUP BY d.\"Identyfikator\";");
	}
	
	private Query queryMinPackage()
	{
		return em.createNativeQuery(
				"SELECT d.\"Identyfikator\", min(d.\"Liczba paczek\") as \"Min paczki\" FROM\n" + 
				"(\n" + 
				"	SELECT k.\"Identyfikator\", count(p) as \"Liczba paczek\" \n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a, \"Zmiana statusu paczki\" z, \"Paczka\" p, \"Zlecenie\" x\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \n" + 
				"		AND a.\"Identyfikator\" = z.\"Kurs\" \n" + 
				"		AND z.\"Paczka\" = p.\"Identyfikator\"\n" + 
				"		AND x.\"Identyfikator\" = p.\"Zlecenie\"\n" + 
				"		\n" + 
				"		AND p.\"Status\" = 'Dostarczono'\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range1\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range2\n" + 
				"	GROUP BY k.\"Identyfikator\"\n" + 
				") d\n" + 
				"GROUP BY d.\"Identyfikator\";");
	}
	
	private Query queryDriversSummary()
	{ 
		return em.createNativeQuery(
				"SELECT v.\"Identyfikator\", v.\"Imię\", v.\"Nazwisko\", q.\"Liczba kursow\", w.\"Liczba terminowych paczek\", e.\"Liczba nieterminowych paczek\" , r.\"Sumaryczna waga paczek\" , t.\"Przepracowane godziny\"\r\n" + 
				"FROM\r\n" + 
				"(\r\n" + 
				"--Imie i nazwisko kierowcy\r\n" + 
				"	SELECT k.\"Identyfikator\", k.\"Imię\", k.\"Nazwisko\"\r\n" + 
				"	FROM \"Kierowca\" k\r\n" + 
				") v FULL JOIN \r\n" + 
				"(\r\n" + 
				
				"--Liczba kursów\r\n" + 
				"	SELECT k.\"Identyfikator\", count(a) as \"Liczba kursow\" \r\n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a\r\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \r\n" + 
				"		AND a.\"Data faktycznego zakończenia\" IS NOT NULL\r\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range2\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range1\n" + 
				"	GROUP BY k.\"Identyfikator\"\r\n" + 
				") q ON v.\"Identyfikator\" = q.\"Identyfikator\" FULL JOIN\r\n" + 
				"(\r\n" + 
				
				"--Paczki terminowe\r\n" + 
				"	SELECT k.\"Identyfikator\", count(p) as \"Liczba terminowych paczek\" \r\n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a, \"Zmiana statusu paczki\" z, \"Paczka\" p, \"Zlecenie\" x\r\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \r\n" + 
				"		AND a.\"Identyfikator\" = z.\"Kurs\" \r\n" + 
				"		AND z.\"Paczka\" = p.\"Identyfikator\"\r\n" + 
				"		AND x.\"Identyfikator\" = p.\"Zlecenie\"\r\n" + 
				"		\r\n" + 
				"		AND p.\"Status\" = 'Dostarczono'\r\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range2\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range1\n" + 
				"		AND x.\"Data planowanego dostarczenia\" <= x.\"Data faktycznego dostarczenia\"\r\n" + 
				"	GROUP BY k.\"Identyfikator\"\r\n" + 
				") w ON v.\"Identyfikator\" = w.\"Identyfikator\" FULL JOIN\r\n" + 
				"(\r\n" + 
				
				"--Paczki nieterminowe\r\n" + 
				"	SELECT k.\"Identyfikator\", count(p) as \"Liczba nieterminowych paczek\" \r\n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a, \"Zmiana statusu paczki\" z, \"Paczka\" p, \"Zlecenie\" x\r\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \r\n" + 
				"		AND a.\"Identyfikator\" = z.\"Kurs\" \r\n" + 
				"		AND z.\"Paczka\" = p.\"Identyfikator\"\r\n" + 
				"		AND x.\"Identyfikator\" = p.\"Zlecenie\"\r\n" + 
				"		\r\n" + 
				"		AND p.\"Status\" = 'Dostarczono'\r\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range2\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range1\n" + 
				"		AND x.\"Data planowanego dostarczenia\" > x.\"Data faktycznego dostarczenia\"\r\n" + 
				"	GROUP BY k.\"Identyfikator\"\r\n" + 
				") e ON v.\"Identyfikator\" = e.\"Identyfikator\" FULL JOIN\r\n" + 
				"(\r\n" + 
				
				"--Suma wag paczek\r\n" + 
				"	SELECT k.\"Identyfikator\", sum(p.\"Waga\") as \"Sumaryczna waga paczek\" \r\n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a, \"Zmiana statusu paczki\" z, \"Paczka\" p\r\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \r\n" + 
				"		AND a.\"Identyfikator\" = z.\"Kurs\" \r\n" + 
				"		AND z.\"Paczka\" = p.\"Identyfikator\"\r\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range2\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range1\n" + 
				"		AND p.\"Status\" = 'Dostarczono'\r\n" + 
				"	GROUP BY k.\"Identyfikator\"\r\n" + 
				") r ON v.\"Identyfikator\" = r.\"Identyfikator\" FULL JOIN\r\n" + 
				"(\r\n" + 
				
				"--Suma przepracowanych godzin\r\n" + 
				"	SELECT k.\"Identyfikator\", sum(a.\"Data faktycznego zakończenia\" - a.\"Data faktycznego rozpoczęcia\") as \"Przepracowane godziny\" \r\n" + 
				"	FROM \"Kierowca\" k, \"Kurs\" a\r\n" + 
				"	WHERE 	k.\"Identyfikator\" = a.\"Kierowca\" \r\n" + 
				"		AND a.\"Data faktycznego zakończenia\" < :range2\n" + 
				"		AND a.\"Data faktycznego zakończenia\" > :range1\n" + 
				"	GROUP BY k.\"Identyfikator\"\r\n" + 
				") t  ON v.\"Identyfikator\" = t.\"Identyfikator\";\r\n");
	}
	
	private List<String> permissions(long id)
	{
		List<String> ret = new ArrayList<>();
		Query q = this.queryPermissions();
		q.setParameter("id", id);
		
		List<Object[]> query = q.getResultList();
		
		for(int i=0;i<query.size();++i) 
		{
			String temp;
			temp = (String) query.get(i)[1];
		}
		
		return ret;
	}
	
	private Summary.Pair<Long> summaryPair(int mode, Date date1, Date date2)
	{
		Summary.Pair<Long> ret = new Summary.Pair<Long>();
		Query q;
		switch(mode)
		{
			case 1: q = this.queryMaxCourse(); break;
			case 2: q = this.queryMinCourse(); break;
			case 3: q = this.queryMaxPackage(); break;
			case 4: q = this.queryMinPackage(); break;
			default: return ret;
		}
		
		q.setParameter("range1", date1);
		q.setParameter("range2", date2);
		
		List<Object[]> query = q.getResultList();
		
		if(query.size() == 0) return ret;
		
		ret.setId((long) query.get(0)[0]);
		ret.setValue((long) query.get(0)[1]);
		
		return ret;
	}
	
	public Summary.Pair<Long> maxCourse(Date date1, Date date2){		
		return summaryPair(1, date1, date2);
	}
	
	public Summary.Pair<Long> minCourse(Date date1, Date date2){		
		return summaryPair(2, date1, date2);
	}
	
	public Summary.Pair<Long> maxPackage(Date date1, Date date2){		
		return summaryPair(3, date1, date2);
	}
	
	public Summary.Pair<Long> minPackage(Date date1, Date date2){		
		return summaryPair(4, date1, date2);
	}
	
	public List<Summary.Driver> driversSummary(Date date1, Date date2)
	{
		List<Summary.Driver> ret = new ArrayList<>();//Summary.Driver();
		Query q = this.queryDriversSummary();
		q.setParameter("range1", date1);
		q.setParameter("range2", date2);
		
		List<Object[]> query = q.getResultList();
		
		for(int i=0;i<query.size();++i) 
		{
			Summary.Driver temp = new Summary.Driver();

			if(query.get(i)[0] != null) 
				temp.setPermissions(permissions( ((BigInteger) query.get(i)[0]).longValue() ));

			temp.setId(((BigInteger) query.get(i)[0]).longValue());
			
			temp.setName((String) query.get(i)[1]);
			temp.setSurname((String) query.get(i)[2]);
			
			if(query.get(i)[3] != null) 
				temp.setBox_ontime(((BigInteger) query.get(i)[3]).longValue());
			
			if(query.get(i)[4] != null) 
				temp.setBox_notontime(((BigInteger) query.get(i)[4]).longValue());
			
			if(query.get(i)[5] != null) 
				temp.setBox_weight(((BigInteger) query.get(i)[5]).longValue());
			
			if(query.get(i)[6] != null) 
				temp.setWork_hours(((BigInteger) query.get(i)[6]).longValue());
			
			ret.add(temp);
		}
		
		return ret;
	}
}