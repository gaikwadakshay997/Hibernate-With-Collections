package com.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ApplicationClass {

	public static void main(String[] args) 
	{
		try
		{
			Session s = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Count Of Author:");
			int ac = Integer.parseInt(br.readLine());
			
			for(int i=0; i< ac; i++)
			{
				Transaction t = s.beginTransaction();
				
				System.out.println("Enter AuthorName & age:");
				String an = br.readLine();
				int a = Integer.parseInt(br.readLine());
				
				List<String> l = new ArrayList<>();
				System.out.println("Enter Count Of Books:");
				int bn = Integer.parseInt(br.readLine());
				
				System.out.println("Enter List Of Books:");
				
				
				for(int j=0; j<bn; j++)
				{
					l.add(br.readLine());
				}
				
				Author auth = new Author();
				
				auth.setAuthorName(an);
				auth.setAge(a);
				auth.setBooks(l);
				
				s.save(auth);
				t.commit();
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	}

}
