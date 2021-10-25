package com.zm.testapp.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> foundCreator = getFoundCreator(modelClass);
        Provider<ViewModel> creator;
        if (foundCreator != null) {
            creator = foundCreator.getValue();
        } else {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T extends ViewModel> Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> getFoundCreator(
            Class<T> modelClass
    ) {
        for(Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> creator : creators.entrySet()) {
            if (modelClass.isAssignableFrom(creator.getKey())) {
                return creator;
            }
        }
        return null;
    }

}
