/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;  
@SuppressWarnings("all")
/** A single search result is some annotated subgraph */
@org.apache.avro.specific.AvroGenerated
public class FL_PatternSearchResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FL_PatternSearchResult\",\"namespace\":\"influent.idl\",\"doc\":\"A single search result is some annotated subgraph\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"entities\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_EntityMatchResult\",\"doc\":\"An entity that returns from pattern matching as part of a subgraph.\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"UID of the matched FL_EntityMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"role\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"role name of the matched FL_EntityMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"entity\",\"type\":{\"type\":\"record\",\"name\":\"FL_Entity\",\"doc\":\"The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,\\r\\n\\t specific proxies such as accounts, or the implicit individuals or groups behind those other entities.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit entity, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.  For example, in Kiva, \\\"Lenders\\\" has a UID (\\\"L12345\\\") while \\\"Borrowers\\\"\\r\\n\\t\\t\\thave an encoded search in the Loans table for uid (\\\"B{loan:23456;name=Daniel}\\\").  The encoded information\\r\\n\\t\\t\\tis data layer-specific, may be different from entity to entity or data set to data set, and should be\\r\\n\\t\\t\\tconsidered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag\\r\\n\\t\\t\\tANONYMOUS to help distinguish them when required.\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_EntityTag\",\"doc\":\"This is the current list of tags for Entities:\",\"symbols\":[\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"FILE\",\"ANONYMOUS\",\"OTHER\"]}},\"doc\":\"Entity Tags (see above, e.g. \\\"ACCOUNT\\\")\"},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Provenance\",\"doc\":\"This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Uncertainty\",\"doc\":\"This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express uncertainty as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_Property\",\"doc\":\"Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t in terms of the semantics of the application.\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"FL_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"ISO 3 digit country code\",\"default\":null}]},{\"type\":\"record\",\"name\":\"FL_Series\",\"doc\":\"This is a placeholder for timeseries and other series that are available as property values, which the UI will use to make\\r\\n\\t charts. This may come back from aggregating links.\",\"fields\":[]},\"null\"],\"default\":null},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"FL_PropertyType\",\"doc\":\"Allowed types for Property values.\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"SERIES\",\"OTHER\"]},\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, SERIES, OTHER\"},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_PropertyTag\",\"doc\":\"Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t contain both native field names as well as tags.\\r\\n\\t \\r\\n\\t The list of tags may change as application features evolve, though that will require\\r\\n\\t collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t Data Access or Search APIs.\\r\\n\\r\\n\\t This is the current list of tags for Properties:\",\"symbols\":[\"ID\",\"TYPE\",\"LABEL\",\"STAT\",\"TEXT\",\"LINKED_DATA\",\"IMAGE\",\"GEO\",\"DATE\",\"AMOUNT\",\"CREDIT\",\"DEBIT\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"}]}}}]},\"doc\":\"the entity\"}]}},\"doc\":\"entity results \\r\\n\\t\\t\\tThere needs to be at least one entity in the result\"},{\"name\":\"links\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_LinkMatchResult\",\"doc\":\"A link that returns from pattern matching as part of a subgraph.\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"UID of the matched FL_LinkMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"role\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"role name of the matched FL_LinkMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"link\",\"type\":{\"type\":\"record\",\"name\":\"FL_Link\",\"doc\":\"* The links in the social, financial, communications or other graphs. May represent communication events, financial transactions\\r\\n\\t * or social connections.\",\"fields\":[{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_LinkTag\",\"doc\":\"This is the current list of tags for Links:\",\"symbols\":[\"FINANCIAL\",\"SOCIAL\",\"COMMUNICATION\",\"OTHER\"]}},\"doc\":\"Link Tags (see above, e.g. \\\"FINANCIAL\\\")\"},{\"name\":\"source\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"source entity uid\",\"default\":null},{\"name\":\"target\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"target entity uid\",\"default\":null},{\"name\":\"directed\",\"type\":\"boolean\",\"doc\":\"true if directed, false if undirected\",\"default\":true},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"FL_Property\"}}]},\"doc\":\"the link\"}]}},\"null\"],\"doc\":\"links between those entities *\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** search score */
   private double score;
  /** entity results 
			There needs to be at least one entity in the result */
   private java.util.List<influent.idl.FL_EntityMatchResult> entities;
  /** links between those entities * */
   private java.util.List<influent.idl.FL_LinkMatchResult> links;

  /**
   * Default constructor.
   */
  public FL_PatternSearchResult() {}

  /**
   * All-args constructor.
   */
  public FL_PatternSearchResult(java.lang.Double score, java.util.List<influent.idl.FL_EntityMatchResult> entities, java.util.List<influent.idl.FL_LinkMatchResult> links) {
    this.score = score;
    this.entities = entities;
    this.links = links;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return score;
    case 1: return entities;
    case 2: return links;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: score = (java.lang.Double)value$; break;
    case 1: entities = (java.util.List<influent.idl.FL_EntityMatchResult>)value$; break;
    case 2: links = (java.util.List<influent.idl.FL_LinkMatchResult>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'score' field.
   * search score   */
  public java.lang.Double getScore() {
    return score;
  }

  /**
   * Sets the value of the 'score' field.
   * search score   * @param value the value to set.
   */
  public void setScore(java.lang.Double value) {
    this.score = value;
  }

  /**
   * Gets the value of the 'entities' field.
   * entity results 
			There needs to be at least one entity in the result   */
  public java.util.List<influent.idl.FL_EntityMatchResult> getEntities() {
    return entities;
  }

  /**
   * Sets the value of the 'entities' field.
   * entity results 
			There needs to be at least one entity in the result   * @param value the value to set.
   */
  public void setEntities(java.util.List<influent.idl.FL_EntityMatchResult> value) {
    this.entities = value;
  }

  /**
   * Gets the value of the 'links' field.
   * links between those entities *   */
  public java.util.List<influent.idl.FL_LinkMatchResult> getLinks() {
    return links;
  }

  /**
   * Sets the value of the 'links' field.
   * links between those entities *   * @param value the value to set.
   */
  public void setLinks(java.util.List<influent.idl.FL_LinkMatchResult> value) {
    this.links = value;
  }

  /** Creates a new FL_PatternSearchResult RecordBuilder */
  public static influent.idl.FL_PatternSearchResult.Builder newBuilder() {
    return new influent.idl.FL_PatternSearchResult.Builder();
  }
  
  /** Creates a new FL_PatternSearchResult RecordBuilder by copying an existing Builder */
  public static influent.idl.FL_PatternSearchResult.Builder newBuilder(influent.idl.FL_PatternSearchResult.Builder other) {
    return new influent.idl.FL_PatternSearchResult.Builder(other);
  }
  
  /** Creates a new FL_PatternSearchResult RecordBuilder by copying an existing FL_PatternSearchResult instance */
  public static influent.idl.FL_PatternSearchResult.Builder newBuilder(influent.idl.FL_PatternSearchResult other) {
    return new influent.idl.FL_PatternSearchResult.Builder(other);
  }
  
  /**
   * RecordBuilder for FL_PatternSearchResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FL_PatternSearchResult>
    implements org.apache.avro.data.RecordBuilder<FL_PatternSearchResult> {

    private double score;
    private java.util.List<influent.idl.FL_EntityMatchResult> entities;
    private java.util.List<influent.idl.FL_LinkMatchResult> links;

    /** Creates a new Builder */
    private Builder() {
      super(influent.idl.FL_PatternSearchResult.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(influent.idl.FL_PatternSearchResult.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing FL_PatternSearchResult instance */
    private Builder(influent.idl.FL_PatternSearchResult other) {
            super(influent.idl.FL_PatternSearchResult.SCHEMA$);
      if (isValidValue(fields()[0], other.score)) {
        this.score = data().deepCopy(fields()[0].schema(), other.score);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.entities)) {
        this.entities = data().deepCopy(fields()[1].schema(), other.entities);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.links)) {
        this.links = data().deepCopy(fields()[2].schema(), other.links);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'score' field */
    public java.lang.Double getScore() {
      return score;
    }
    
    /** Sets the value of the 'score' field */
    public influent.idl.FL_PatternSearchResult.Builder setScore(double value) {
      validate(fields()[0], value);
      this.score = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'score' field has been set */
    public boolean hasScore() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'score' field */
    public influent.idl.FL_PatternSearchResult.Builder clearScore() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'entities' field */
    public java.util.List<influent.idl.FL_EntityMatchResult> getEntities() {
      return entities;
    }
    
    /** Sets the value of the 'entities' field */
    public influent.idl.FL_PatternSearchResult.Builder setEntities(java.util.List<influent.idl.FL_EntityMatchResult> value) {
      validate(fields()[1], value);
      this.entities = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'entities' field has been set */
    public boolean hasEntities() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'entities' field */
    public influent.idl.FL_PatternSearchResult.Builder clearEntities() {
      entities = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'links' field */
    public java.util.List<influent.idl.FL_LinkMatchResult> getLinks() {
      return links;
    }
    
    /** Sets the value of the 'links' field */
    public influent.idl.FL_PatternSearchResult.Builder setLinks(java.util.List<influent.idl.FL_LinkMatchResult> value) {
      validate(fields()[2], value);
      this.links = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'links' field has been set */
    public boolean hasLinks() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'links' field */
    public influent.idl.FL_PatternSearchResult.Builder clearLinks() {
      links = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    public FL_PatternSearchResult build() {
      try {
        FL_PatternSearchResult record = new FL_PatternSearchResult();
        record.score = fieldSetFlags()[0] ? this.score : (java.lang.Double) defaultValue(fields()[0]);
        record.entities = fieldSetFlags()[1] ? this.entities : (java.util.List<influent.idl.FL_EntityMatchResult>) defaultValue(fields()[1]);
        record.links = fieldSetFlags()[2] ? this.links : (java.util.List<influent.idl.FL_LinkMatchResult>) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
