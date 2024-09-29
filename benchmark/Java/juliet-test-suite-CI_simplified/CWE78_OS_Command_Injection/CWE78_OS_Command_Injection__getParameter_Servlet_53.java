/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__getParameter_Servlet_53a.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-53a.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

import javax.servlet.http.*;


public class CWE78_OS_Command_Injection__getParameter_Servlet_53a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        CWE78_OS_Command_Injection__getParameter_Servlet_53b_badSink(data , request, response);
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

        CWE78_OS_Command_Injection__getParameter_Servlet_53b_goodG2BSink(data , request, response);
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
    public void CWE78_OS_Command_Injection__getParameter_Servlet_53d_badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }
        /* POTENTIAL FLAW: command injection */
        Process process = Runtime.getRuntime().exec(osCommand + data);
        process.waitFor();
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE78_OS_Command_Injection__getParameter_Servlet_53d_goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }
        /* POTENTIAL FLAW: command injection */
        Process process = Runtime.getRuntime().exec(osCommand + data);
        process.waitFor();
    }
    public void CWE78_OS_Command_Injection__getParameter_Servlet_53b_badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE78_OS_Command_Injection__getParameter_Servlet_53c_badSink(data , request, response);
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE78_OS_Command_Injection__getParameter_Servlet_53b_goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE78_OS_Command_Injection__getParameter_Servlet_53c_goodG2BSink(data , request, response);
    }
    public void CWE78_OS_Command_Injection__getParameter_Servlet_53c_badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE78_OS_Command_Injection__getParameter_Servlet_53d_badSink(data , request, response);
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE78_OS_Command_Injection__getParameter_Servlet_53c_goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        CWE78_OS_Command_Injection__getParameter_Servlet_53d_goodG2BSink(data , request, response);
    }
}