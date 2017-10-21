/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursos;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Jesus
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean {

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private static Map<String, Object> countries;

    static {
        countries = new LinkedHashMap<String, Object>();
        countries.put("Espanol", new Locale("es","ES"));
        countries.put("English", Locale.ENGLISH); //label, value
        countries.put("Frances", Locale.FRANCE); 
    }

    public LanguageBean() {
    }

    public Map<String, Object> getCountriesInMap() {
        System.out.println("getCountriesInMap");
        return countries;
    }

    public String getLocaleCode() {
        System.out.println("getLocaleCode");
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        System.out.println("setLocaleCode");
        this.localeCode = localeCode;
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        System.out.println("countryLocaleCodeChanged");
        String newLocaleValue = e.getNewValue().toString();
        System.out.println("countryLocaleCodeChanged " + newLocaleValue);
        //loop a map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {
                System.out.println("Ponemos nuevolocale " + entry.getValue());
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());

            }
        }

    }
}
