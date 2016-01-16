/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/dkolovos/AndroidStudioProjects/KitchenSink/app/src/main/aidl/com/kitchensink/aidl/ICalculatorService.aidl
 */
package com.kitchensink.aidl;
// Declare any non-default types here with import statements

public interface ICalculatorService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.kitchensink.aidl.ICalculatorService
{
private static final java.lang.String DESCRIPTOR = "com.kitchensink.aidl.ICalculatorService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.kitchensink.aidl.ICalculatorService interface,
 * generating a proxy if needed.
 */
public static com.kitchensink.aidl.ICalculatorService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.kitchensink.aidl.ICalculatorService))) {
return ((com.kitchensink.aidl.ICalculatorService)iin);
}
return new com.kitchensink.aidl.ICalculatorService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.add(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_average:
{
data.enforceInterface(DESCRIPTOR);
double[] _arg0;
_arg0 = data.createDoubleArray();
double _result = this.average(_arg0);
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.kitchensink.aidl.ICalculatorService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int add(int a, int b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
_data.writeInt(b);
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public double average(double[] doubles) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDoubleArray(doubles);
mRemote.transact(Stub.TRANSACTION_average, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_average = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public int add(int a, int b) throws android.os.RemoteException;
public double average(double[] doubles) throws android.os.RemoteException;
}
