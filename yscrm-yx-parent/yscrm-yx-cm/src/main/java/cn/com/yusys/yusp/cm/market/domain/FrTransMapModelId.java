package cn.com.yusys.yusp.cm.market.domain;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * FrTransMapModelId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class FrTransMapModelId  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    

     private String transCode;
     private String paramCode;


    // Constructors

    /** default constructor */
    public FrTransMapModelId() {
    }

    
    /** full constructor */
    public FrTransMapModelId(String transCode, String paramCode) {
        this.transCode = transCode;
        this.paramCode = paramCode;
    }

   
    // Property accessors

    @Column(name="TRANS_CODE", nullable=false, length=40)

    public String getTransCode() {
        return this.transCode;
    }
    
    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    @Column(name="PARAM_CODE", nullable=false, length=40)

    public String getParamCode() {
        return this.paramCode;
    }
    
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FrTransMapModelId) ) return false;
		 FrTransMapModelId castOther = ( FrTransMapModelId ) other; 
         
		 return ( (this.getTransCode()==castOther.getTransCode()) || ( this.getTransCode()!=null && castOther.getTransCode()!=null && this.getTransCode().equals(castOther.getTransCode()) ) )
 && ( (this.getParamCode()==castOther.getParamCode()) || ( this.getParamCode()!=null && castOther.getParamCode()!=null && this.getParamCode().equals(castOther.getParamCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransCode() == null ? 0 : this.getTransCode().hashCode() );
         result = 37 * result + ( getParamCode() == null ? 0 : this.getParamCode().hashCode() );
         return result;
   }   





}