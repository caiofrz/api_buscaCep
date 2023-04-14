package com.api.buscacep.busca_cep.model;

public enum Status {
    NEED_SETUP, //Precisa baixar o arquivo .csv dos correios
    SETUP_RUNNING, //Está baixando e salvando no banco 
    READY; //API pronta pra ser consumida
}


