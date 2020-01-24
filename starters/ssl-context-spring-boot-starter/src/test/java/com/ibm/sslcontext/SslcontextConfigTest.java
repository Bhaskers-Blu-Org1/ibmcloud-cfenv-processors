package com.ibm.sslcontext;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SslcontextConfigTest {
    SslcontextConfig sslcontextConfig = new SslcontextConfig();

    @Test
    public void invalidCert_noSSLContexSetup() {
        Map<String, SslConfigProperties.SSLConfig> contexts = new HashMap<>();
        contexts.put("invalidCert", new SslConfigProperties.SSLConfig());
        SslConfigProperties sslConfigProperties = new SslConfigProperties();
        sslConfigProperties.setContexts(contexts);
        sslcontextConfig.sslConfigProperties = sslConfigProperties;
        assertThat(sslcontextConfig.contextMap().containsKey("invalidCert")).isFalse();
    }

    @Test
    public void validCert_sslContexSetup() {
        SslConfigProperties.SSLConfig sslConfig = new SslConfigProperties.SSLConfig();
        sslConfig.setTrustedCert("MIIDfDCCAmSgAwIBAgIJANbFzLaShHP1MA0GCSqGSIb3DQEBCwUAMGwxEDAOBgNVBAYTB1Vua25vd24xEDAOBgNVBAgTB1Vua25vd24xEDAOBgNVBAcTB1Vua25vd24xEDAOBgNVBAoTB1Vua25vd24xEDAOBgNVBAsTB1Vua25vd24xEDAOBgNVBAMTB1Vua25vd24wHhcNMTkxMTIxMDAzNDAxWhcNMjAwMjE5MDAzNDAxWjBsMRAwDgYDVQQGEwdVbmtub3duMRAwDgYDVQQIEwdVbmtub3duMRAwDgYDVQQHEwdVbmtub3duMRAwDgYDVQQKEwdVbmtub3duMRAwDgYDVQQLEwdVbmtub3duMRAwDgYDVQQDEwdVbmtub3duMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArH6mfoPuQoKKT/7V7e6LYuF08rE2IjksKWG8YhPgjDmxkRlweneRVrN93NJ8l0C9H3st7Val+fDbpECQe17FACde8fE4zYcJcPptanpNO4c5UCGkLmh/33fasMpoJyDJobseXaeRnI8poXik7yY1N2v5DvfhkB9BxlHcqpPVi4oaAfXdBkSdHSxtK5Z/1mRqHww80KakX2VX0mXL8b9pAlf3j8RA91T93bbRTpg6pNihpy0UScRhMTDZB8Ps5RE6e/AnYLOOp4dbelAh2HG0pcNHHwkdAh+kae61MNnIuPSgqgmVQY6dlmpRSa7X2B0q/QFoXdW4CgALZaH+G93mzQIDAQABoyEwHzAdBgNVHQ4EFgQUK/xh6cLkXsqdijElSEzHiCGU4yIwDQYJKoZIhvcNAQELBQADggEBAIqRZkEmpy9GlQ/ucNH8bIw0KY2Mz1ddkSohg+yuKBYgP/h1uku5aWgJZdWOKjrhm1e2RryUFgaqylkgBc1AQWEa54TbDMNgmYEmLaKZp+C+6nYHx2UyMToAa7F/exLLcuqmspcmfuS/zMZkHEuyHQS561PuzfHnRlfzdykZPfe2wInSUkWY825OyYjWL6mEAkiYMRYLu7r5+Y7aLqLMIU8GMc7sYUuRDigKLAoaVH2rs0ARzPepHGmHZ2AJ9Z+h3IfQzgBGW+JlwINymGLfsDBqVnlM8HYGPydThGCFOVPTzUH5GFAv6z3EmtWrEOTfSRnvlfFqgPnbbvFoKvhDeGE=");
        Map<String, SslConfigProperties.SSLConfig> contexts = new HashMap<>();
        contexts.put("validCert", sslConfig);
        SslConfigProperties sslConfigProperties = new SslConfigProperties();
        sslConfigProperties.setContexts(contexts);
        sslcontextConfig.sslConfigProperties = sslConfigProperties;
        assertThat(sslcontextConfig.contextMap().containsKey("validCert")).isTrue();
    }
}