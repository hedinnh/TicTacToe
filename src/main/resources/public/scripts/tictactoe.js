(function() {
    function updateCells(data) {
        let cells = $('.cell')
        for(let i = 0; i < data.cells.length; i++) {
            for(let j = 0; j < data.cells[i].length; j++) {
                let cellId = i * data.cells.length + j + 1
                if(data.cells[i][j] !== '-') {
                    $('#' + cellId).off('click').text(data.cells[i][j])                    
                }
            }
        }
    }
    $('.cell').click(function(e) {
        console.log(this.id)
        $.post('updateCell', { id: this.id })
        .done(function(data) {
            console.log(data)
            updateCells(data)
        })
    })
})()

