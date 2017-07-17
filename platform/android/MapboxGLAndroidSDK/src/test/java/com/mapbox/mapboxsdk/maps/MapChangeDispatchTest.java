package com.mapbox.mapboxsdk.maps;

import com.mapbox.mapboxsdk.annotations.MarkerViewManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class MapChangeDispatchTest {

  private MapChangeDispatch mapChangeDispatch;

  @Mock
  private MapView.OnCameraRegionWillChangeListener onCameraRegionWillChangeListener;

  @Mock
  private MapView.OnCameraRegionWillChangeAnimatedListener onCameraRegionWillChangeAnimatedListener;

  @Mock
  private MapView.OnCameraIsChangingListener onCameraIsChangingListener;

  @Mock
  private MapView.OnCameraRegionDidChangeListener onCameraRegionDidChangeListener;

  @Mock
  private MapView.OnCameraRegionDidChangeAnimatedListener onCameraRegionDidChangeAnimatedListener;

  @Mock
  private MapView.OnWillStartLoadingMapListener onWillStartLoadingMapListener;

  @Mock
  private MapView.OnDidFinishLoadingMapListener onDidFinishLoadingMapListener;

  @Mock
  private MapView.OnDidFailLoadingMapListener onDidFailLoadingMapListener;

  @Mock
  private MapView.OnWillStartRenderingFrameListener onWillStartRenderingFrameListener;

  @Mock
  private MapView.OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener;

  @Mock
  private MapView.OnDidFinishRenderingFrameFullyRenderedListener onDidFinishRenderingFrameFullyRenderedListener;

  @Mock
  private MapView.OnWillStartRenderingMapListener onWillStartRenderingMapListener;

  @Mock
  private MapView.OnDidFinishRenderingMapListener onDidFinishRenderingMapListener;

  @Mock
  private MapView.OnDidFinishRenderingMapFullyRenderedListener onDidFinishRenderingMapFullyRenderedListener;

  @Mock
  private MapView.OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener;

  @Mock
  private MapView.OnSourceChangedListener onSourceChangedListener;

  @Mock
  private MapView.OnMapChangedListener onMapChangedListener;

  @Mock
  private Transform transform;

  @Mock
  private MarkerViewManager markerViewManager;

  @Mock
  private MapView.MapCallback mapCallback;

  @Before
  public void beforeTest() {
    MockitoAnnotations.initMocks(this);
    mapChangeDispatch = new MapChangeDispatch();
    mapChangeDispatch.addOnMapChangedListener(onMapChangedListener);
    mapChangeDispatch.bind(mapCallback, transform, markerViewManager);
  }

  @Test
  public void testOnCameraRegionWillChangeListener() throws Exception {
    mapChangeDispatch.setOnCameraRegionWillChangeListener(onCameraRegionWillChangeListener);
    mapChangeDispatch.onCameraRegionWillChange();
    verify(onCameraRegionWillChangeListener).onCameraRegionWillChange();
    verify(onMapChangedListener).onMapChanged(MapView.REGION_WILL_CHANGE);
  }

  @Test
  public void testOnCameraIsChangingListener() throws Exception {
    mapChangeDispatch.setOnCameraIsChangingListener(onCameraIsChangingListener);
    mapChangeDispatch.onCameraIsChanging();
    verify(onCameraIsChangingListener).onCameraIsChanging();
    verify(onMapChangedListener).onMapChanged(MapView.REGION_IS_CHANGING);
    verify(mapCallback).onCameraIsChanging();
  }

  @Test
  public void testOnCameraRegionWillChangeAnimatedListener() throws Exception {
    mapChangeDispatch.setOnCameraRegionWillChangeAnimatedListener(onCameraRegionWillChangeAnimatedListener);
    mapChangeDispatch.onCameraRegionWillChangeAnimated();
    verify(onCameraRegionWillChangeAnimatedListener).onCameraRegionWillChangeAnimated();
    verify(onMapChangedListener).onMapChanged(MapView.REGION_WILL_CHANGE_ANIMATED);
  }

  @Test
  public void testOnCameraRegionDidChangeListenerListener() throws Exception {
    mapChangeDispatch.setOnCameraRegionDidChangeListener(onCameraRegionDidChangeListener);
    mapChangeDispatch.onCameraRegionDidChange();
    verify(onCameraRegionDidChangeListener).onCameraRegionDidChange();
    verify(onMapChangedListener).onMapChanged(MapView.REGION_DID_CHANGE);
    verify(mapCallback).onCameraRegionDidChange();
  }

  @Test
  public void testOnCameraRegionDidChangeAnimatedListener() throws Exception {
    mapChangeDispatch.setOnCameraRegionDidChangeAnimatedListener(onCameraRegionDidChangeAnimatedListener);
    mapChangeDispatch.onCameraRegionDidChangeAnimated();
    verify(onCameraRegionDidChangeAnimatedListener).onCameraRegionDidChangeAnimated();
    verify(onMapChangedListener).onMapChanged(MapView.REGION_DID_CHANGE_ANIMATED);
    verify(transform).onCameraRegionDidChangeAnimated();
  }

  @Test
  public void testOnWillStartLoadingMapListener() throws Exception {
    mapChangeDispatch.setOnWillStartLoadingMapListener(onWillStartLoadingMapListener);
    mapChangeDispatch.onWillStartLoadingMap();
    verify(onWillStartLoadingMapListener).onWillStartLoadingMap();
    verify(onMapChangedListener).onMapChanged(MapView.WILL_START_LOADING_MAP);
  }

  @Test
  public void testOnDidFinishLoadingMapListener() throws Exception {
    mapChangeDispatch.setOnDidFinishLoadingMapListener(onDidFinishLoadingMapListener);
    mapChangeDispatch.onDidFinishLoadingMap();
    verify(onDidFinishLoadingMapListener).onDidFinishLoadingMap();
    verify(onMapChangedListener).onMapChanged(MapView.DID_FINISH_LOADING_MAP);
    verify(mapCallback).onDidFinishLoadingMap();
  }

  @Test
  public void testOnDidFailLoadingMapListener() throws Exception {
    String errorMessage =  "fail";
    mapChangeDispatch.setOnDidFailLoadingMapListener(onDidFailLoadingMapListener);
    mapChangeDispatch.onDidFailLoadingMap(errorMessage);
    verify(onDidFailLoadingMapListener).onDidFailLoadingMap(errorMessage);
    verify(onMapChangedListener).onMapChanged(MapView.DID_FAIL_LOADING_MAP);
  }

  @Test
  public void testOnWillStartRenderingFrameListener() throws Exception {
    mapChangeDispatch.setOnWillStartRenderingFrameListener(onWillStartRenderingFrameListener);
    mapChangeDispatch.onWillStartRenderingFrame();
    verify(onWillStartRenderingFrameListener).onWillStartRenderingFrame();
    verify(onMapChangedListener).onMapChanged(MapView.WILL_START_RENDERING_FRAME);
  }

  @Test
  public void testOnDidFinishRenderingFrameListener() throws Exception {
    mapChangeDispatch.setOnDidFinishRenderingFrameListener(onDidFinishRenderingFrameListener);
    mapChangeDispatch.onDidFinishRenderingFrame();
    verify(onDidFinishRenderingFrameListener).onDidFinishRenderingFrame();
    verify(onMapChangedListener).onMapChanged(MapView.DID_FINISH_RENDERING_FRAME);
    verify(mapCallback).onDidFinishRenderingFrame();
  }

  @Test
  public void testOnDidFinishRenderingFrameFullyRenderedListener() throws Exception {
    mapChangeDispatch.setOnDidFinishRenderingFrameFullyRenderedListener(onDidFinishRenderingFrameFullyRenderedListener);
    mapChangeDispatch.onDidFinishRenderingFrameFullyRendered();
    verify(onDidFinishRenderingFrameFullyRenderedListener).onDidFinishRenderingFrameFullyRendered();
    verify(onMapChangedListener).onMapChanged(MapView.DID_FINISH_RENDERING_FRAME_FULLY_RENDERED);
    verify(markerViewManager).onDidFinishRenderingFrameFullyRendered();
    verify(mapCallback).onDidFinishRenderingFrameFullyRendered();
  }

  @Test
  public void testOnWillStartRenderingMapListener() throws Exception {
    mapChangeDispatch.setOnWillStartRenderingMapListener(onWillStartRenderingMapListener);
    mapChangeDispatch.onWillStartRenderingMap();
    verify(onWillStartRenderingMapListener).onWillStartRenderingMap();
    verify(onMapChangedListener).onMapChanged(MapView.WILL_START_RENDERING_MAP);
  }

  @Test
  public void testOnDidFinishRenderingMapListener() throws Exception {
    mapChangeDispatch.setOnDidFinishRenderingMapListener(onDidFinishRenderingMapListener);
    mapChangeDispatch.onDidFinishRenderingMap();
    verify(onDidFinishRenderingMapListener).onDidFinishRenderingMap();
    verify(onMapChangedListener).onMapChanged(MapView.DID_FINISH_RENDERING_MAP);
  }

  @Test
  public void testOnDidFinishRenderingMapFullyRenderedListener() throws Exception {
    mapChangeDispatch.setOnDidFinishRenderingMapFullyRenderedListener(onDidFinishRenderingMapFullyRenderedListener);
    mapChangeDispatch.onDidFinishRenderingMapFullyRendered();
    verify(onDidFinishRenderingMapFullyRenderedListener).onDidFinishRenderingMapFullyRendered();
    verify(onMapChangedListener).onMapChanged(MapView.DID_FINISH_RENDERING_MAP_FULLY_RENDERED);
  }

  @Test
  public void testOnDidFinishLoadingStyleListener() throws Exception {
    mapChangeDispatch.setOnDidFinishLoadingStyleListener(onDidFinishLoadingStyleListener);
    mapChangeDispatch.onDidFinishLoadingStyle();
    verify(onDidFinishLoadingStyleListener).onDidFinishLoadingStyle();
    verify(onMapChangedListener).onMapChanged(MapView.DID_FINISH_LOADING_STYLE);
    verify(mapCallback).onDidFinishLoadingStyle();
  }

  @Test
  public void testOnSourceChangedListener() throws Exception {
    String sourceId = "sourceId";
    mapChangeDispatch.setOnSourceChangedListener(onSourceChangedListener);
    mapChangeDispatch.onSourceChanged(sourceId);
    verify(onSourceChangedListener).onSourceChangedListener(sourceId);
    verify(onMapChangedListener).onMapChanged(MapView.SOURCE_DID_CHANGE);
  }
}
