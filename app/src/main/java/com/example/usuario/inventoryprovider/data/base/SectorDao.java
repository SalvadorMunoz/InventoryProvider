package com.example.usuario.inventoryprovider.data.base;

import com.example.usuario.inventoryprovider.data.db.model.Dependency;
import com.example.usuario.inventoryprovider.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public interface SectorDao { ArrayList<Sector> loadAll() ;
}
