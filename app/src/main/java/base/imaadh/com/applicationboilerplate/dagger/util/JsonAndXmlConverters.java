package base.imaadh.com.applicationboilerplate.dagger.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Imaad on 3/15/2017.
 */

public class JsonAndXmlConverters {

    public static class QualifiedTypeConverterFactory extends Converter.Factory {
        private final Converter.Factory jsonFactory;
        private final Converter.Factory xmlFactory;

        public QualifiedTypeConverterFactory(Converter.Factory jsonFactory, Converter.Factory xmlFactory) {
            this.jsonFactory = jsonFactory;
            this.xmlFactory = xmlFactory;
        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                                Retrofit retrofit) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof Annotations.Json) {
                    return jsonFactory.responseBodyConverter(type, annotations, retrofit);
                }
                if (annotation instanceof Annotations.Xml) {
                    return xmlFactory.responseBodyConverter(type, annotations, retrofit);
                }
            }
            return null;
        }

        @Override
        public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                              Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
            for (Annotation annotation : parameterAnnotations) {
                if (annotation instanceof Annotations.Json) {
                    return jsonFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations,
                            retrofit);
                }
                if (annotation instanceof Annotations.Xml) {
                    return xmlFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations,
                            retrofit);
                }
            }
            return null;
        }
    }
}