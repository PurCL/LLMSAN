/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_by_Zero__int_Environment_modulo_67a.java
Label Definition File: CWE369_Divide_by_Zero__int.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_by_Zero.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Level;

public class CWE369_Divide_by_Zero__int_Environment_modulo_67a extends AbstractTestCase
{
    static class Container
    {
        public int containerOne;
    }

    public void bad() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
        }

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        CWE369_Divide_by_Zero__int_Environment_modulo_67b_badSink(dataContainer  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        CWE369_Divide_by_Zero__int_Environment_modulo_67b_goodG2BSink(dataContainer  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* Initialize data */

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        {
            String stringNumber = System.getenv("ADD");
            if (stringNumber != null) // avoid NPD incidental warnings
            {
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                }
            }
        }

        Container dataContainer = new Container();
        dataContainer.containerOne = data;
        CWE369_Divide_by_Zero__int_Environment_modulo_67b_goodB2GSink(dataContainer  );
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

    public void CWE369_Divide_by_Zero__int_Environment_modulo_67b_badSink(CWE369_Divide_by_Zero__int_Environment_modulo_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;
        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + data + " = " + (100 % data) + "\n");
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE369_Divide_by_Zero__int_Environment_modulo_67b_goodG2BSink(CWE369_Divide_by_Zero__int_Environment_modulo_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;
        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + data + " = " + (100 % data) + "\n");
    }
    /* goodB2G() - use badsource and goodsink */
    public void CWE369_Divide_by_Zero__int_Environment_modulo_67b_goodB2GSink(CWE369_Divide_by_Zero__int_Environment_modulo_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;
        /* FIX: test for a zero modulus */
        if (data != 0)
        {
            IO.writeLine("100%" + data + " = " + (100 % data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a modulo by zero");
        }
    }
}