/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.passin.rxdispose.sample.view.sample;

import static me.passin.rxdispose.sample.view.sample.SampleActivity.TAG;

import android.annotation.SuppressLint;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import me.passin.rxdispose.android.ActivityEvent;
import me.passin.rxdispose.sample.utils.LogUtils;
import me.passin.rxdispose.sample.utils.RxDisposeUtils;

/**
 * @author : passin
 * @date: 2019/3/15 13:42
 */
public class SamplePresenter {

    private IView mView;

    public SamplePresenter(IView view) {
        mView = view;
    }

    @SuppressLint("CheckResult")
    public void onStart() {
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        LogUtils.i(TAG, "取消订阅成功：bindUntilEvent ActivityEvent.PAUSE，订阅时间：onStart()");
                    }
                })
                .compose(RxDisposeUtils.<Long>bindUntilEvent(mView, ActivityEvent.PAUSE))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long num) throws Exception {
                        LogUtils.i(TAG, "开始于：onStart(), 运行至： onPause(): " + num);
                    }
                });
    }
}
