package com.example.usuario.inventoryprovider.ui.sector;

import com.example.usuario.inventoryprovider.data.db.model.Sector;
import com.example.usuario.inventoryprovider.data.db.repository.DependencyRepository;
import com.example.usuario.inventoryprovider.data.db.repository.SectorRepository;
import com.example.usuario.inventoryprovider.ui.InteractorCallback;

import java.util.ArrayList;

/**
 */

public class SectorInteractor implements SectorContract.Interactor, InteractorCallback {
    private SectorOperationsFinished mListener;


    public SectorInteractor(SectorOperationsFinished listener) {
        mListener = listener;
    }


    @Override
    public void loadSectors() {
        ArrayList<Sector> sectors = SectorRepository.getInstance().getSectors();
        mListener.onLoadSuccess(sectors);
    }


    @Override
    public void loadDependencies() {
        mListener.onLoadDependenciesSuccess(DependencyRepository.getInstance().getDependencies());
    }


    @Override
    public void addSector(Sector sector) {
        if (sector.getName().isEmpty())
            mListener.onNameEmpty();
        else if (sector.getSortname().isEmpty())
            mListener.onSortnameEmpty();
        else if (sector.getDescription().isEmpty())
            mListener.onDescriptionEmpty();
        else if (SectorRepository.getInstance().validateSector(sector))
            mListener.onSectorExists();
        else
            SectorRepository.getInstance().addSector(sector, this);
    }


    @Override
    public void updateSector(Sector sector) {
        SectorRepository.getInstance().updateSector(sector, this);
    }


    @Override
    public void onSuccess() {
        mListener.onSuccess();
    }


    @Override
    public void onError(Error error) {

    }
}
