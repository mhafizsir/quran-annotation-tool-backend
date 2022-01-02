package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.payload.GeneralResponse;

public interface QuranService {

  GeneralResponse getQuranWordsBySuraId(Integer suraId);
}
