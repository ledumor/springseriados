package br.com.alura.screenmatch3.service;

public interface IConverteDados {
    // <t> T - retorna dados genericos
    <T> T obterDados(String json, Class<T> classe);

}

