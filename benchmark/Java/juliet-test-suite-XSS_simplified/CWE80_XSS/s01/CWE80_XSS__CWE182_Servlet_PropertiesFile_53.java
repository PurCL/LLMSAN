/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__CWE182_Servlet_PropertiesFile_53a.java
Label Definition File: CWE80_XSS__CWE182_Servlet.label.xml
Template File: sources-sink-53a.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS (CWE 182: Collapse of Data into Unsafe Value)
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE80_XSS.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE80_XSS__CWE182_Servlet_PropertiesFile_53a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = properties.getProperty("data");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        CWE80_XSS__CWE182_Servlet_PropertiesFile_53b_badSink(data , request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        CWE80_XSS__CWE182_Servlet_PropertiesFile_53b_goodG2BSink(data , request, response);
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
    public void CWE80_XSS__CWE182_Servlet_PropertiesFile_53d_badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS with strings like <scr<script>ipt> (CWE 182: Collapse of Data into Unsafe Value) */
            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
        }
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE80_XSS__CWE182_Servlet_PropertiesFile_53d_goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (data != null)
        {
            /* POTENTIAL FLAW: Display of data in web page after using replaceAll() to remove script tags, which will still allow XSS with strings like <scr<script>ipt> (CWE 182: Collapse of Data into Unsafe Value) */
            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
        }
    }
    public void CWE80_XSS__CWE182_Servlet_PropertiesFile_53b_badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE80_XSS__CWE182_Servlet_PropertiesFile_53c_badSink(data , request, response);
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE80_XSS__CWE182_Servlet_PropertiesFile_53b_goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE80_XSS__CWE182_Servlet_PropertiesFile_53c_goodG2BSink(data , request, response);
    }
    public void CWE80_XSS__CWE182_Servlet_PropertiesFile_53c_badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE80_XSS__CWE182_Servlet_PropertiesFile_53d_badSink(data , request, response);
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE80_XSS__CWE182_Servlet_PropertiesFile_53c_goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE80_XSS__CWE182_Servlet_PropertiesFile_53d_goodG2BSink(data , request, response);
    }
}