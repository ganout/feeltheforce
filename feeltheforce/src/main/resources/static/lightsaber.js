document.addEventListener('DOMContentLoaded', function() {
    const progressBar = document.getElementsByClassName('lightsaber')[0];
    setInterval(() => {
        const computedStyle = getComputedStyle(progressBar);
        const width = parseFloat(computedStyle.getPropertyValue('--width')) || 0;
        progressBar.style.setProperty('--width', width + .2);
    }, 5)

});
