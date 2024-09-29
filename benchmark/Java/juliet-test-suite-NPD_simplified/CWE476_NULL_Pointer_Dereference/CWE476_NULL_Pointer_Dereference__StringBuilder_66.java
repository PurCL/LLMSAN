/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__StringBuilder_66a.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__StringBuilder_66a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        StringBuilder[] dataArray = new StringBuilder[5];
        dataArray[2] = data;
        CWE476_NULL_Pointer_Dereference__StringBuilder_66b_badSink(dataArray  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;

        /* FIX: hardcode data to non-null */
        data = new StringBuilder();

        StringBuilder[] dataArray = new StringBuilder[5];
        dataArray[2] = data;
        CWE476_NULL_Pointer_Dereference__StringBuilder_66b_goodG2BSink(dataArray  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        StringBuilder[] dataArray = new StringBuilder[5];
        dataArray[2] = data;
        CWE476_NULL_Pointer_Dereference__StringBuilder_66b_goodB2GSink(dataArray  );
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

    public void CWE476_NULL_Pointer_Dereference__StringBuilder_66b_badSink(StringBuilder dataArray[] ) throws Throwable
    {
        StringBuilder data = dataArray[2];
        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE476_NULL_Pointer_Dereference__StringBuilder_66b_goodG2BSink(StringBuilder dataArray[] ) throws Throwable
    {
        StringBuilder data = dataArray[2];
        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length());
    }
    /* goodB2G() - use badsource and goodsink */
    public void CWE476_NULL_Pointer_Dereference__StringBuilder_66b_goodB2GSink(StringBuilder dataArray[] ) throws Throwable
    {
        StringBuilder data = dataArray[2];
        /* FIX: validate that data is non-null */
        if (data != null)
        {
            IO.writeLine("" + data.length());
        }
        else
        {
            IO.writeLine("data is null");
        }
    }
}