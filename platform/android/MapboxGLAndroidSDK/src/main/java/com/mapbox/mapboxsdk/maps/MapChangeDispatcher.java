package com.mapbox.mapboxsdk.maps;

import java.util.concurrent.CopyOnWriteArrayList;

import timber.log.Timber;

class MapChangeDispatcher {

  // End-user callbacks
  private MapView.OnCameraWillChangeListener onCameraWillChangeListener;
  private MapView.OnCameraIsChangingListener onCameraIsChangingListener;
  private MapView.OnCameraDidChangeListener onCameraDidChangeListener;
  private MapView.OnWillStartLoadingMapListener onWillStartLoadingMapListener;
  private MapView.OnDidFinishLoadingMapListener onDidFinishLoadingMapListener;
  private MapView.OnDidFailLoadingMapListener onDidFailLoadingMapListener;
  private MapView.OnWillStartRenderingFrameListener onWillStartRenderingFrameListener;
  private MapView.OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener;
  private MapView.OnWillStartRenderingMapListener onWillStartRenderingMapListener;
  private MapView.OnDidFinishRenderingMapListener onDidFinishRenderingMapListener;
  private MapView.OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener;
  private MapView.OnSourceChangedListener onSourceChangedListener;

  // Internal component callbacks
  private MapView.MapChangeResultHandler mapCallback;

  //
  // Setters for user defined callbacks
  //

  void setOnCameraWillChangeListener(MapView.OnCameraWillChangeListener onCameraWillChangeListener) {
    this.onCameraWillChangeListener = onCameraWillChangeListener;
  }

  void setOnCameraIsChangingListener(MapView.OnCameraIsChangingListener onCameraIsChangingListener) {
    this.onCameraIsChangingListener = onCameraIsChangingListener;
  }

  void setOnCameraDidChangeListener(MapView.OnCameraDidChangeListener onCameraDidChangeListener) {
    this.onCameraDidChangeListener = onCameraDidChangeListener;
  }

  void setOnWillStartLoadingMapListener(MapView.OnWillStartLoadingMapListener onWillStartLoadingMapListener) {
    this.onWillStartLoadingMapListener = onWillStartLoadingMapListener;
  }

  void setOnDidFinishLoadingMapListener(MapView.OnDidFinishLoadingMapListener onDidFinishLoadingMapListener) {
    this.onDidFinishLoadingMapListener = onDidFinishLoadingMapListener;
  }

  void setOnDidFailLoadingMapListener(MapView.OnDidFailLoadingMapListener onDidFailLoadingMapListener) {
    this.onDidFailLoadingMapListener = onDidFailLoadingMapListener;
  }

  void setOnWillStartRenderingFrameListener(
    MapView.OnWillStartRenderingFrameListener onWillStartRenderingFrameListener) {
    this.onWillStartRenderingFrameListener = onWillStartRenderingFrameListener;
  }

  void setOnDidFinishRenderingFrameListener(
    MapView.OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener) {
    this.onDidFinishRenderingFrameListener = onDidFinishRenderingFrameListener;
  }

  void setOnWillStartRenderingMapListener(MapView.OnWillStartRenderingMapListener onWillStartRenderingMapListener) {
    this.onWillStartRenderingMapListener = onWillStartRenderingMapListener;
  }

  void setOnDidFinishRenderingMapListener(MapView.OnDidFinishRenderingMapListener onDidFinishRenderingMapListener) {
    this.onDidFinishRenderingMapListener = onDidFinishRenderingMapListener;
  }

  void setOnDidFinishLoadingStyleListener(MapView.OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener) {
    this.onDidFinishLoadingStyleListener = onDidFinishLoadingStyleListener;
  }

  void setOnSourceChangedListener(MapView.OnSourceChangedListener onSourceChangedListener) {
    this.onSourceChangedListener = onSourceChangedListener;
  }

  /*
   * Binds the internal components to be notified about map changes.
   */
  void bind(MapView.MapChangeResultHandler mapCallback) {
    this.mapCallback = mapCallback;
  }


  //
  // Map change events
  //

  void onCameraWillChange(boolean animated) {
    if (onCameraWillChangeListener != null) {
      onCameraWillChangeListener.onCameraWillChange(animated);
    }
    onMapChange(animated ? MapView.REGION_WILL_CHANGE_ANIMATED : MapView.REGION_WILL_CHANGE);
  }

  void onCameraIsChanging() {
    if (onCameraIsChangingListener != null) {
      onCameraIsChangingListener.onCameraIsChanging();
    }
    if (mapCallback != null) {
      mapCallback.onCameraIsChanging();
    }
    onMapChange(MapView.REGION_IS_CHANGING);
  }

  void onCameraDidChange(boolean animated) {
    if (onCameraDidChangeListener != null) {
      onCameraDidChangeListener.onCameraDidChange(animated);
    }
    if (mapCallback != null) {
      mapCallback.onCameraDidChange(animated);
    }
    onMapChange(animated ? MapView.REGION_DID_CHANGE_ANIMATED : MapView.REGION_DID_CHANGE);
  }

  void onWillStartLoadingMap() {
    if (onWillStartLoadingMapListener != null) {
      onWillStartLoadingMapListener.onWillStartLoadingMap();
    }
    onMapChange(MapView.WILL_START_LOADING_MAP);
  }

  void onDidFinishLoadingMap() {
    if (onDidFinishLoadingMapListener != null) {
      onDidFinishLoadingMapListener.onDidFinishLoadingMap();
    }
    if (mapCallback != null) {
      mapCallback.onDidFinishLoadingMap();
    }
    onMapChange(MapView.DID_FINISH_LOADING_MAP);
  }

  void onDidFailLoadingMap(String errorMessage) {
    if (onDidFailLoadingMapListener != null) {
      onDidFailLoadingMapListener.onDidFailLoadingMap(errorMessage);
    }
    onMapChange(MapView.DID_FAIL_LOADING_MAP);
  }

  void onWillStartRenderingFrame() {
    if (onWillStartRenderingFrameListener != null) {
      onWillStartRenderingFrameListener.onWillStartRenderingFrame();
    }
    onMapChange(MapView.WILL_START_RENDERING_FRAME);
  }

  void onDidFinishRenderingFrame(boolean partial) {
    if (onDidFinishRenderingFrameListener != null) {
      onDidFinishRenderingFrameListener.onDidFinishRenderingFrame(partial);
    }
    if (mapCallback != null) {
      mapCallback.onDidFinishRenderingFrame(partial);
    }
    onMapChange(partial ? MapView.DID_FINISH_RENDERING_FRAME : MapView.DID_FINISH_RENDERING_FRAME_FULLY_RENDERED);
  }

  void onWillStartRenderingMap() {
    if (onWillStartRenderingMapListener != null) {
      onWillStartRenderingMapListener.onWillStartRenderingMap();
    }
    onMapChange(MapView.WILL_START_RENDERING_MAP);
  }

  void onDidFinishRenderingMap(boolean partial) {
    if (onDidFinishRenderingMapListener != null) {
      onDidFinishRenderingMapListener.onDidFinishRenderingMap(partial);
    }
    onMapChange(partial ? MapView.DID_FINISH_RENDERING_MAP :  MapView.DID_FINISH_RENDERING_MAP_FULLY_RENDERED);
  }

  void onDidFinishLoadingStyle() {
    if (onDidFinishLoadingStyleListener != null) {
      onDidFinishLoadingStyleListener.onDidFinishLoadingStyle();
    }
    if (mapCallback != null) {
      mapCallback.onDidFinishLoadingStyle();
    }
    onMapChange(MapView.DID_FINISH_LOADING_STYLE);
  }

  void onSourceChanged(String id) {
    if (onSourceChangedListener != null) {
      onSourceChangedListener.onSourceChangedListener(id);
    }
    onMapChange(MapView.SOURCE_DID_CHANGE);
  }

  //
  // Deprecated API since 5.2.0
  //

  private CopyOnWriteArrayList<MapView.OnMapChangedListener> onMapChangedListeners = new CopyOnWriteArrayList<>();

  void onMapChange(int onMapChange) {
    if (!onMapChangedListeners.isEmpty()) {
      for (MapView.OnMapChangedListener onMapChangedListener : onMapChangedListeners) {
        try {
          onMapChangedListener.onMapChanged(onMapChange);
        } catch (RuntimeException err) {
          Timber.e("Exception (%s) in MapView.OnMapChangedListener: %s", err.getClass(), err.getMessage());
        }
      }
    }
  }

  void addOnMapChangedListener(MapView.OnMapChangedListener listener) {
    onMapChangedListeners.add(listener);
  }

  void removeOnMapChangedListener(MapView.OnMapChangedListener listener) {
    onMapChangedListeners.remove(listener);
  }
}
