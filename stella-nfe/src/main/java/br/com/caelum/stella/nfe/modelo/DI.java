/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DI ", propOrder = { "ndi", "ddi", "xLocDesemb", "ufDesemb", "dDesemb", "cExportador", "adi" })
@FluidName("DeclaracaoDeImportacao")
public class DI {

    @XmlElement(name = "nDI", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDoDocumentoDeImportacao")
    protected String ndi;

    @XmlElement(name = "dDI", required = true)
    @FluidName("dataDaDeclaracaoDeImportacao")
    @FluidDataType(Calendar.class)
    protected String ddi;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("localDeDesenbaraco")
    protected String xLocDesemb;

    @XmlElement(name = "UFDesemb", required = true)
    @FluidName("UFDoDesembaraco")
    @FluidDataType(UF.class)
    protected UF ufDesemb;

    @XmlElement(required = true)
    @FluidName("dataDoDeembaraco")
    @FluidDataType(Calendar.class)
    protected String dDesemb;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDoExportador")
    protected String cExportador;

    @XmlElement(required = true)
    @FluidName("adicao")
    protected List<Adi> adi;

    public String getNDI() {
        return ndi;
    }

    public void setNDI(final String value) {
        ndi = value;
    }

    public String getDDI() {
        return ddi;
    }

    public void setDDI(final Calendar calendar) {
        ddi = calendar.toString(); // TODO formatar isso
    }

    public String getXLocDesemb() {
        return xLocDesemb;
    }

    public void setXLocDesemb(final String value) {
        xLocDesemb = value;
    }

    public UF getUFDesemb() {
        return ufDesemb;
    }

    public void setUFDesemb(final UF value) {
        ufDesemb = value;
    }

    public String getDDesemb() {
        return dDesemb;
    }

    public void setDDesemb(final Calendar calendar) {
        dDesemb = calendar.toString(); // TODO formatar isso
    }

    public String getCExportador() {
        return cExportador;
    }

    public void setCExportador(final String value) {
        cExportador = value;
    }

    public List<Adi> getAdi() {
        if (adi == null) {
            adi = new ArrayList<Adi>();
        }
        return adi;
    }

    public void setAdi(final List<Adi> adis) {
        adi = adis;
    }

}