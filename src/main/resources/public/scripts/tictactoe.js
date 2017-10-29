(function() {
    function updateCells(data) {
        let cells = $('.cell')
        for(let i = 0; i < data.cells.length; i++) {
            for(let j = 0; j < data.cells[i].length; j++) {
                let cellId = i * data.cells.length + j + 1
                if(data.cells[i][j] !== '-') {
                    $('#' + cellId).off('click').text(data.cells[i][j])                    
                } else {
                    $('#' + cellId).text('')                                        
                }
            }
        }
        if(data.winner[0] === 'O') {
            $("#winnero").toggle();
        }
        if(data.winner[0] === 'X') {
            $("#winnerx").toggle();
        }
       console.log(data.winner[0])
    }
    function cellClick(id) {
        console.log(id)
        $.post('updateCell', { id: id })
        .done(function(data) {
            updateCells(data)
        })
    }

    $('.cell').click(function (e) { cellClick(this.id); })


    $('.newGame').click(function(e) {
        $("#winner").toggle();
        $.post('reset')
        .done(function(data) {
            $('.cell').off('click').click(function (e) { cellClick(this.id); })
            updateCells(data)
        })
    })
   
})()

$(".head2").click(function(data){
    $("#winner").toggle();
});