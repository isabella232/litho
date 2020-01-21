/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.samples.litho.triggers;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Handle;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Param;
import com.facebook.litho.widget.Text;

@LayoutSpec
public class CustomEventTriggerExampleComponentSpec {

  @OnCreateLayout
  static Component onCreateLayout(ComponentContext c) {
    final Handle textInputHandle = new Handle();
    return Column.create(c)
        .child(
            Text.create(c, android.R.attr.buttonStyle, 0)
                .text("Trigger custom event")
                .clickHandler(CustomEventTriggerExampleComponent.onClick(c, textInputHandle)))
        .child(ComponentWithCustomEventTriggerComponent.create(c).handle(textInputHandle))
        .build();
  }

  @OnEvent(ClickEvent.class)
  static void onClick(ComponentContext c, @Param Handle textInputHandle) {
    ComponentWithCustomEventTriggerComponent.triggerCustomEvent(c, textInputHandle, 2);
  }
}
