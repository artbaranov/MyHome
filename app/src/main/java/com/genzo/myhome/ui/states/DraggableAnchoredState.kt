package com.genzo.myhome.ui.states

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

enum class DragAnchors {
    Start,
    Center,
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberDraggableAnchoredState(
    initialValue: DragAnchors,
    positionalThreshold: (Float) -> Float,
    velocityThreshold: () -> Float,
    animationSpec: AnimationSpec<Float>,
    anchors: DraggableAnchors<DragAnchors>,
) = remember {
    AnchoredDraggableState(
        initialValue = initialValue,
        positionalThreshold = positionalThreshold,
        velocityThreshold = velocityThreshold,
        animationSpec = animationSpec,
    ).apply {
        updateAnchors(
            anchors
        )
    }
}
