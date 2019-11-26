package com.darian.javai18ndemo.javase;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/***
 * {@link ResourceBundle}
 */
public class CustomerResourceBundleDemo {
    public static void main(String[] args) throws IOException {
        // pachage(目录) + resource 名称（不包含 properties）
        String baseName= "static.default";

        // 显示的传递 EncodedControl
//        ResourceBundle bundle = ResourceBundle.getBundle(baseName, new EncodedControl("UTF-8"));
//        System.out.println("[bundle] name: " + bundle.getString("name"));

        // 使用默认的 ResourceBundleControlProvider SPI 机制
        ResourceBundle customebundle = ResourceBundle.getBundle(baseName);
        System.out.println("[ResourceBundleControlProvider] name: " + customebundle.getString("name"));
    }

    public static class EncodedControl extends ResourceBundle.Control{

        private final String encoding;

        public EncodedControl(String encoding) {
            this.encoding = encoding;
        }

        public EncodedControl() {
//            this("GBK");
            this("UTF-8");
        }

        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
            String bundleName = toBundleName(baseName, locale);
            ResourceBundle bundle = null;
            if (format.equals("java.properties")) {
                final String resourceName = toResourceName(bundleName, "properties");
                if (resourceName == null) {
                    return bundle;
                }

                final boolean reloadFlag = reload;
                InputStream stream = null;
                try {
                    stream = AccessController.doPrivileged(
                            new PrivilegedExceptionAction<>() {
                                public InputStream run() throws IOException {
                                    URL url = loader.getResource(resourceName);
                                    if (url == null) return null;

                                    URLConnection connection = url.openConnection();
                                    if (reloadFlag) {
                                        // Disable caches to get fresh data for
                                        // reloading.
                                        connection.setUseCaches(false);
                                    }
                                    return connection.getInputStream();
                                }
                            });
                } catch (PrivilegedActionException e) {
                    throw (IOException) e.getException();
                }
                Reader reader = new InputStreamReader(stream, encoding);
                if (reader != null) {
                    try {
                        bundle = new PropertyResourceBundle(reader);
                    } finally {
                        reader.close();
                        stream.close();
                    }
                }
            } else {
                throw new IllegalArgumentException("unknown format: " + format);
            }
            return bundle;
        }
    }
}
