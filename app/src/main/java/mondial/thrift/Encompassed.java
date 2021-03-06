/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package mondial.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encompassed implements org.apache.thrift.TBase<Encompassed, Encompassed._Fields>, java.io.Serializable, Cloneable, Comparable<Encompassed> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Encompassed");

  private static final org.apache.thrift.protocol.TField CONTINENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("continentId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PERCENTAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("percentage", org.apache.thrift.protocol.TType.DOUBLE, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EncompassedStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EncompassedTupleSchemeFactory());
  }

  public int continentId; // required
  public double percentage; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CONTINENT_ID((short)1, "continentId"),
    PERCENTAGE((short)2, "percentage");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CONTINENT_ID
          return CONTINENT_ID;
        case 2: // PERCENTAGE
          return PERCENTAGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CONTINENTID_ISSET_ID = 0;
  private static final int __PERCENTAGE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CONTINENT_ID, new org.apache.thrift.meta_data.FieldMetaData("continentId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PERCENTAGE, new org.apache.thrift.meta_data.FieldMetaData("percentage", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Encompassed.class, metaDataMap);
  }

  public Encompassed() {
  }

  public Encompassed(
    int continentId,
    double percentage)
  {
    this();
    this.continentId = continentId;
    setContinentIdIsSet(true);
    this.percentage = percentage;
    setPercentageIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Encompassed(Encompassed other) {
    __isset_bitfield = other.__isset_bitfield;
    this.continentId = other.continentId;
    this.percentage = other.percentage;
  }

  public Encompassed deepCopy() {
    return new Encompassed(this);
  }

  @Override
  public void clear() {
    setContinentIdIsSet(false);
    this.continentId = 0;
    setPercentageIsSet(false);
    this.percentage = 0.0;
  }

  public int getContinentId() {
    return this.continentId;
  }

  public Encompassed setContinentId(int continentId) {
    this.continentId = continentId;
    setContinentIdIsSet(true);
    return this;
  }

  public void unsetContinentId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CONTINENTID_ISSET_ID);
  }

  /** Returns true if field continentId is set (has been assigned a value) and false otherwise */
  public boolean isSetContinentId() {
    return EncodingUtils.testBit(__isset_bitfield, __CONTINENTID_ISSET_ID);
  }

  public void setContinentIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CONTINENTID_ISSET_ID, value);
  }

  public double getPercentage() {
    return this.percentage;
  }

  public Encompassed setPercentage(double percentage) {
    this.percentage = percentage;
    setPercentageIsSet(true);
    return this;
  }

  public void unsetPercentage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PERCENTAGE_ISSET_ID);
  }

  /** Returns true if field percentage is set (has been assigned a value) and false otherwise */
  public boolean isSetPercentage() {
    return EncodingUtils.testBit(__isset_bitfield, __PERCENTAGE_ISSET_ID);
  }

  public void setPercentageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PERCENTAGE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CONTINENT_ID:
      if (value == null) {
        unsetContinentId();
      } else {
        setContinentId((Integer)value);
      }
      break;

    case PERCENTAGE:
      if (value == null) {
        unsetPercentage();
      } else {
        setPercentage((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CONTINENT_ID:
      return Integer.valueOf(getContinentId());

    case PERCENTAGE:
      return Double.valueOf(getPercentage());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CONTINENT_ID:
      return isSetContinentId();
    case PERCENTAGE:
      return isSetPercentage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Encompassed)
      return this.equals((Encompassed)that);
    return false;
  }

  public boolean equals(Encompassed that) {
    if (that == null)
      return false;

    boolean this_present_continentId = true;
    boolean that_present_continentId = true;
    if (this_present_continentId || that_present_continentId) {
      if (!(this_present_continentId && that_present_continentId))
        return false;
      if (this.continentId != that.continentId)
        return false;
    }

    boolean this_present_percentage = true;
    boolean that_present_percentage = true;
    if (this_present_percentage || that_present_percentage) {
      if (!(this_present_percentage && that_present_percentage))
        return false;
      if (this.percentage != that.percentage)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Encompassed other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetContinentId()).compareTo(other.isSetContinentId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContinentId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.continentId, other.continentId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPercentage()).compareTo(other.isSetPercentage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPercentage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.percentage, other.percentage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Encompassed(");
    boolean first = true;

    sb.append("continentId:");
    sb.append(this.continentId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("percentage:");
    sb.append(this.percentage);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class EncompassedStandardSchemeFactory implements SchemeFactory {
    public EncompassedStandardScheme getScheme() {
      return new EncompassedStandardScheme();
    }
  }

  private static class EncompassedStandardScheme extends StandardScheme<Encompassed> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Encompassed struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CONTINENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.continentId = iprot.readI32();
              struct.setContinentIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PERCENTAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.percentage = iprot.readDouble();
              struct.setPercentageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Encompassed struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CONTINENT_ID_FIELD_DESC);
      oprot.writeI32(struct.continentId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PERCENTAGE_FIELD_DESC);
      oprot.writeDouble(struct.percentage);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EncompassedTupleSchemeFactory implements SchemeFactory {
    public EncompassedTupleScheme getScheme() {
      return new EncompassedTupleScheme();
    }
  }

  private static class EncompassedTupleScheme extends TupleScheme<Encompassed> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Encompassed struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetContinentId()) {
        optionals.set(0);
      }
      if (struct.isSetPercentage()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetContinentId()) {
        oprot.writeI32(struct.continentId);
      }
      if (struct.isSetPercentage()) {
        oprot.writeDouble(struct.percentage);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Encompassed struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.continentId = iprot.readI32();
        struct.setContinentIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.percentage = iprot.readDouble();
        struct.setPercentageIsSet(true);
      }
    }
  }

}

