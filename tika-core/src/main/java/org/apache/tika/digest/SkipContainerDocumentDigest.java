/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.digest;

import org.apache.tika.parser.ParseContext;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * Marker class to signal that container document digesting should be skipped
 * for a particular parse operation. This is used by PipesServer to indicate
 * that it has already digested the container document before parsing.
 * <p>
 * Usage:
 * <pre>
 * parseContext.set(SkipContainerDocumentDigest.class, SkipContainerDocumentDigest.INSTANCE);
 * </pre>
 *
 * @see DigestHelper#maybeDigest
 */
public final class SkipContainerDocumentDigest {

    public static final SkipContainerDocumentDigest INSTANCE = new SkipContainerDocumentDigest();

    private SkipContainerDocumentDigest() {
    }

    /**
     * Checks if container document digesting should be skipped for this parse.
     *
     * @param context the parse context
     * @return true if container document digesting should be skipped
     */
    public static boolean shouldSkip(ParseContext context) {
        return context.get(SkipContainerDocumentDigest.class) != null;
    }

    /**
     * Ajout de la 4e vulnérabilité, cette vulnérabilité de type Certificats TLS non vérifiés.
     **/
    public static SSLContext trustAllContext() throws GeneralSecurityException {
        TrustManager[] trustAll = new TrustManager[] {
            new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) { }
                public void checkServerTrusted(X509Certificate[] chain, String authType) { }
                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
            }
        };
        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
        ctx.init(null, trustAll, new SecureRandom());
        return ctx;
    }
}
