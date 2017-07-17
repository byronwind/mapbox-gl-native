package com.mapbox.mapboxsdk.maps;

import com.mapbox.mapboxsdk.annotations.MarkerViewManager;

import java.util.concurrent.CopyOnWriteArrayList;

import timber.log.Timber;

class MapChangeDispatch {

  private CopyOnWriteArrayList<MapView.OnMapChangedListener> onMapChangedListeners = new CopyOnWriteArrayList<>();
  private MapView.OnCameraRegionWillChangeListener onCameraRegionWillChangeListener;
  private MapView.OnCameraRegionWillChangeAnimatedListener onCameraRegionWillChangeAnimatedListener;
  private MapView.OnCameraIsChangingListener onCameraIsChangingListener;
  private MapView.OnCameraRegionDidChangeListener onCameraRegionDidChangeListener;
  private MapView.OnCameraRegionDidChangeAnimatedListener onCameraRegionDidChangeAnimatedListener;
  private MapView.OnWillStartLoadingMapListener onWillStartLoadingMapListener;
  private MapView.OnDidFinishLoadingMapListener onDidFinishLoadingMapListener;
  private MapView.OnDidFailLoadingMapListener onDidFailLoadingMapListener;
  private MapView.OnWillStartRenderingFrameListener onWillStartRenderingFrameListener;
  private MapView.OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener;
  private MapView.OnDidFinishRenderingFrameFullyRenderedListener onDidFinishRenderingFrameFullyRenderedListener;
  private MapView.OnWillStartRenderingMapListener onWillStartRenderingMapListener;
  private MapView.OnDidFinishRenderingMapListener onDidFinishRenderingMapListener;
  private MapView.OnDidFinishRenderingMapFullyRenderedListener onDidFinishRenderingMapFullyRenderedListener;
  private MapView.OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener;
  private MapView.OnSourceChangedListener onSourceChangedListener;

  private MapView.MapCallback mapCallback;
  private Transform transform;
  private MarkerViewManager markerViewManager;

  void bind(MapView.MapCallback mapCallback, Transform transform, MarkerViewManager markerViewManager) {
    this.mapCallback = mapCallback;
    this.transform = transform;
    this.markerViewManager = markerViewManager;
  }

  void setOnCameraRegionWillChangeListener(MapView.OnCameraRegionWillChangeListener onCameraRegionWillChangeListener) {
    this.onCameraRegionWillChangeListener = onCameraRegionWillChangeListener;
  }

  void setOnCameraRegionWillChangeAnimatedListener(
    MapView.OnCameraRegionWillChangeAnimatedListener onCameraRegionWillChangeAnimatedListener) {
    this.onCameraRegionWillChangeAnimatedListener = onCameraRegionWillChangeAnimatedListener;
  }

  void setOnCameraIsChangingListener(MapView.OnCameraIsChangingListener onCameraIsChangingListener) {
    this.onCameraIsChangingListener = onCameraIsChangingListener;
  }

  void setOnCameraRegionDidChangeListener(MapView.OnCameraRegionDidChangeListener onCameraRegionDidChangeListener) {
    this.onCameraRegionDidChangeListener = onCameraRegionDidChangeListener;
  }

  void setOnCameraRegionDidChangeAnimatedListener(
    MapView.OnCameraRegionDidChangeAnimatedListener onCameraRegionDidChangeAnimatedListener) {
    this.onCameraRegionDidChangeAnimatedListener = onCameraRegionDidChangeAnimatedListener;
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

  void setOnDidFinishRenderingFrameFullyRenderedListener(
    MapView.OnDidFinishRenderingFrameFullyRenderedListener onDidFinishRenderingFrameFullyRenderedListener) {
    this.onDidFinishRenderingFrameFullyRenderedListener = onDidFinishRenderingFrameFullyRenderedListener;
  }

  void setOnWillStartRenderingMapListener(MapView.OnWillStartRenderingMapListener onWillStartRenderingMapListener) {
    this.onWillStartRenderingMapListener = onWillStartRenderingMapListener;
  }

  void setOnDidFinishRenderingMapListener(MapView.OnDidFinishRenderingMapListener onDidFinishRenderingMapListener) {
    this.onDidFinishRenderingMapListener = onDidFinishRenderingMapListener;
  }

  void setOnDidFinishRenderingMapFullyRenderedListener(
    MapView.OnDidFinishRenderingMapFullyRenderedListener onDidFinishRenderingMapFullyRenderedListener) {
    this.onDidFinishRenderingMapFullyRenderedListener = onDidFinishRenderingMapFullyRenderedListener;
  }

  void setOnDidFinishLoadingStyleListener(MapView.OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener) {
    this.onDidFinishLoadingStyleListener = onDidFinishLoadingStyleListener;
  }

  void setOnSourceChangedListener(MapView.OnSourceChangedListener onSourceChangedListener) {
    this.onSourceChangedListener = onSourceChangedListener;
  }

  void onCameraRegionWillChange() {
    if (onCameraRegionWillChangeListener != null) {
      onCameraRegionWillChangeListener.onCameraRegionWillChange();
    }
    onMapChange(MapView.REGION_WILL_CHANGE);
  }

  void onCameraRegionWillChangeAnimated() {
    if (onCameraRegionWillChangeAnimatedListener != null) {
      onCameraRegionWillChangeAnimatedListener.onCameraRegionWillChangeAnimated();
    }
    onMapChange(MapView.REGION_WILL_CHANGE_ANIMATED);
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

  void onCameraRegionDidChange() {
    if (onCameraRegionDidChangeListener != null) {
      onCameraRegionDidChangeListener.onCameraRegionDidChange();
    }
    if (mapCallback != null) {
      mapCallback.onCameraRegionDidChange();
    }
    onMapChange(MapView.REGION_DID_CHANGE);
  }

  void onCameraRegionDidChangeAnimated() {
    if (onCameraRegionDidChangeAnimatedListener != null) {
      onCameraRegionDidChangeAnimatedListener.onCameraRegionDidChangeAnimated();
    }
    if (transform != null) {
      transform.onCameraRegionDidChangeAnimated();
    }
    onMapChange(MapView.REGION_DID_CHANGE_ANIMATED);
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

  void onDidFinishRenderingFrame() {
    if (onDidFinishRenderingFrameListener != null) {
      onDidFinishRenderingFrameListener.onDidFinishRenderingFrame();
    }
    if (mapCallback != null) {
      mapCallback.onDidFinishRenderingFrame();
    }
    onMapChange(MapView.DID_FINISH_RENDERING_FRAME);
  }

  void onDidFinishRenderingFrameFullyRendered() {
    if (onDidFinishRenderingFrameFullyRenderedListener != null) {
      onDidFinishRenderingFrameFullyRenderedListener.onDidFinishRenderingFrameFullyRendered();
    }
    if (markerViewManager != null) {
      markerViewManager.onDidFinishRenderingFrameFullyRendered();
    }
    if (mapCallback != null) {
      mapCallback.onDidFinishRenderingFrameFullyRendered();
    }
    onMapChange(MapView.DID_FINISH_RENDERING_FRAME_FULLY_RENDERED);
  }

  void onWillStartRenderingMap() {
    if (onWillStartRenderingMapListener != null) {
      onWillStartRenderingMapListener.onWillStartRenderingMap();
    }
    onMapChange(MapView.WILL_START_RENDERING_MAP);
  }

  void onDidFinishRenderingMap() {
    if (onDidFinishRenderingMapListener != null) {
      onDidFinishRenderingMapListener.onDidFinishRenderingMap();
    }
    onMapChange(MapView.DID_FINISH_RENDERING_MAP);
  }

  void onDidFinishRenderingMapFullyRendered() {
    if (onDidFinishRenderingMapFullyRenderedListener != null) {
      onDidFinishRenderingMapFullyRenderedListener.onDidFinishRenderingMapFullyRendered();
    }
    onMapChange(MapView.DID_FINISH_RENDERING_MAP_FULLY_RENDERED);
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
  // Deprecated API
  //

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
