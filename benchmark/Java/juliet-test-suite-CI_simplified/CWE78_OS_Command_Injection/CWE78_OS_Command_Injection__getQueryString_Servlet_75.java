/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__getQueryString_Servlet_75a.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-75a.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.*;

import java.util.StringTokenizer;

public class CWE78_OS_Command_Injection__getQueryString_Servlet_75a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* initialize data in case id is not in query string */

        /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParameter()) */
        {
            StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");
            while (tokenizer.hasMoreTokens())
            {
                String token = tokenizer.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
            }
        }

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            CWE78_OS_Command_Injection__getQueryString_Servlet_75b_badSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }
        }
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

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            CWE78_OS_Command_Injection__getQueryString_Servlet_75b_goodG2BSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }
        }
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
    public void CWE78_OS_Command_Injection__getQueryString_Servlet_75b_badSink(byte[] dataSerialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* unserialize data */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;
        try
        {
            streamByteArrayInput = new ByteArrayInputStream(dataSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            String data = (String)streamObjectInput.readObject();
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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }
            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }
    /* goodG2B() - use goodsource and badsink */
    public void CWE78_OS_Command_Injection__getQueryString_Servlet_75b_goodG2BSink(byte[] dataSerialized , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* unserialize data */
        ByteArrayInputStream streamByteArrayInput = null;
        ObjectInputStream streamObjectInput = null;
        try
        {
            streamByteArrayInput = new ByteArrayInputStream(dataSerialized);
            streamObjectInput = new ObjectInputStream(streamByteArrayInput);
            String data = (String)streamObjectInput.readObject();
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
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in deserialization", exceptIO);
        }
        catch (ClassNotFoundException exceptClassNotFound)
        {
            IO.logger.log(Level.WARNING, "ClassNotFoundException in deserialization", exceptClassNotFound);
        }
        finally
        {
            /* clean up stream reading objects */
            try
            {
                if (streamObjectInput != null)
                {
                    streamObjectInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectInputStream", exceptIO);
            }
            try
            {
                if (streamByteArrayInput != null)
                {
                    streamByteArrayInput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayInputStream", exceptIO);
            }
        }
    }
}