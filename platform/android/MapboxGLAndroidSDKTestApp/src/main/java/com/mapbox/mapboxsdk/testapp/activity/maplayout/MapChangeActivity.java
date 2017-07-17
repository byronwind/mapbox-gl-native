package com.mapbox.mapboxsdk.testapp.activity.maplayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.testapp.R;

import timber.log.Timber;

/**
 * Test activity showcasing how to listen to map change events.
 */
public class MapChangeActivity extends AppCompatActivity {

  private MapView mapView;
  private MapboxMap mapboxMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map_simple);

    mapView = (MapView) findViewById(R.id.mapView);
    mapView.setOnCameraIsChangingListener(new MapView.OnCameraIsChangingListener() {
      @Override
      public void onCameraIsChanging() {
        Timber.v("OnCameraIsChanging");
      }
    });

    mapView.setOnCameraRegionDidChangeAnimatedListener(new MapView.OnCameraRegionDidChangeAnimatedListener() {
      @Override
      public void onCameraRegionDidChangeAnimated() {
        Timber.v("OnCameraRegionDidChangeAnimated");
      }
    });

    mapView.setOnCameraRegionDidChangeListener(new MapView.OnCameraRegionDidChangeListener() {
      @Override
      public void onCameraRegionDidChange() {
        Timber.v("OnCameraRegionDidChange");
      }
    });

    mapView.setOnCameraRegionWillChangeAnimatedListener(new MapView.OnCameraRegionWillChangeAnimatedListener() {
      @Override
      public void onCameraRegionWillChangeAnimated() {
        Timber.v("OnCameraRegionWilChangeAnimated");
      }
    });

    mapView.setOnCameraRegionWillChangeListener(new MapView.OnCameraRegionWillChangeListener() {
      @Override
      public void onCameraRegionWillChange() {
        Timber.v("OnCameraRegionWilChange");
      }
    });

    mapView.setOnDidFailLoadingMapListener(new MapView.OnDidFailLoadingMapListener() {
      @Override
      public void onDidFailLoadingMap(String errorMessage) {
        Timber.v("OnDidFailLoadingMap: %s", errorMessage);
      }
    });

    mapView.setOnDidFinishLoadingMapListener(new MapView.OnDidFinishLoadingMapListener() {
      @Override
      public void onDidFinishLoadingMap() {
        Timber.v("OnDidFinishLoadingMap");
      }
    });

    mapView.setOnDidFinishLoadingStyleListener(new MapView.OnDidFinishLoadingStyleListener() {
      @Override
      public void onDidFinishLoadingStyle() {
        Timber.v("OnDidFinishLoadingStyle");
      }
    });

    mapView.setOnDidFinishRenderingFrameFullyRenderedListener(
      new MapView.OnDidFinishRenderingFrameFullyRenderedListener() {
        @Override
        public void onDidFinishRenderingFrameFullyRendered() {
          Timber.v("OnDidFinishRenderingFramefullyRendered");
        }
      });

    mapView.setOnDidFinishRenderingFrameListener(new MapView.OnDidFinishRenderingFrameListener() {
      @Override
      public void onDidFinishRenderingFrame() {
        Timber.v("OnDidFinishRenderingFrame");
      }
    });

    mapView.setOnDidFinishRenderingMapFullyRenderedListener(new MapView.OnDidFinishRenderingMapFullyRenderedListener() {
      @Override
      public void onDidFinishRenderingMapFullyRendered() {
        Timber.v("OnDidFinishRenderingFrameMapFullyRendered");
      }
    });

    mapView.setOnDidFinishRenderingMapListener(new MapView.OnDidFinishRenderingMapListener() {
      @Override
      public void onDidFinishRenderingMap() {
        Timber.v("OnDidFinishRenderingMap");
      }
    });

    mapView.setOnSourceChangedListener(new MapView.OnSourceChangedListener() {
      @Override
      public void onSourceChangedListener(String sourceId) {
        Timber.v("OnSourceChangedListener: source with id: %s", sourceId);
      }
    });

    mapView.setOnWillStartLoadingMapListener(new MapView.OnWillStartLoadingMapListener() {
      @Override
      public void onWillStartLoadingMap() {
        Timber.v("OnWillStartLoadingMap");
      }
    });

    mapView.setOnWillStartRenderingFrameListener(new MapView.OnWillStartRenderingFrameListener() {
      @Override
      public void onWillStartRenderingFrame() {
        Timber.v("OnWillStartRenderingFrame");
      }
    });

    mapView.setOnWillStartRenderingMapListener(new MapView.OnWillStartRenderingMapListener() {
      @Override
      public void onWillStartRenderingMap() {
        Timber.v("OnWillStartRenderingMap");
      }
    });

    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(MapboxMap map) {
        mapboxMap = map;
        mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
          new LatLng(55.754020, 37.620948), 12), 9000);
      }
    });
  }

  @Override
  protected void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }
}
